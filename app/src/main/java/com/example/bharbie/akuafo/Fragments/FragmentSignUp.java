package com.example.bharbie.akuafo.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bharbie.akuafo.R;
import com.example.bharbie.akuafo.User;
import com.example.bharbie.akuafo.UserFire;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import io.realm.Realm;

import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by BHARBIE on 4/16/2017.
 */

public class FragmentSignUp extends Fragment {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    public FragmentSignUp() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_signup, container, false);


        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();


        final EditText editTextEmail = (EditText) view.findViewById(R.id.edit_text_signup_email);
        final EditText editTextName = (EditText) view.findViewById(R.id.edit_text_signup_username);
        final EditText editTextPassword = (EditText) view.findViewById(R.id.edit_text_signup_password);
        final EditText editTextPasswordAgain = (EditText) view.findViewById(R.id.edit_text_signup_password_again);
        final Spinner spinnerSignUp = (Spinner) view.findViewById(R.id.spinner_signup_type);
        Button buttonLogin = (Button) view.findViewById(R.id.button_signup);
        TextView textViewSignUp = (TextView) view.findViewById(R.id.text_view_login);


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_sign_up, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerSignUp.setAdapter(adapter);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id =String.valueOf(Calendar.getInstance().getTimeInMillis()) ;
                String type = spinnerSignUp.getSelectedItem().toString();
                String username = editTextName.getText().toString();
                String email = editTextEmail.getText().toString();
                String password1 = editTextPassword.getText().toString();
                String password2 = editTextPasswordAgain.getText().toString();

                if (username.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your name", Toast.LENGTH_LONG).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your email", Toast.LENGTH_LONG).show();
                } else if (password1.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your password", Toast.LENGTH_LONG).show();
                } else if (password2.isEmpty()) {
                    Toast.makeText(getActivity(), "Please confirm your password", Toast.LENGTH_LONG).show();
                } else if (password1.equals(password2)) {

                   final User user = new User(id,username,email,password1,type);
                   final UserFire userFire = new UserFire(id,username,email,password1,type);

                    mAuth.createUserWithEmailAndPassword(email, password1)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.e(TAG, "createUser:onComplete:" + task.isSuccessful());

                                    if (task.isSuccessful()) {

                                        UserInfo userInfo = task.getResult().getUser();
                                        String email = userInfo.getEmail();
                                        String id = userInfo.getUid();
                                        user.id = id;
                                        userFire.id = id;

                                        mDatabase.child("UserTable").setValue(userFire, new DatabaseReference.CompletionListener() {
                                            @Override
                                            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                                                if (databaseError != null){
                                                   Log.e("ERROR",databaseError.toString());
                                                }
                                            }
                                        });

                                        Toast.makeText(getActivity(),"Sign in successful",Toast.LENGTH_LONG).show();
                                        user.save(user);
                                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                        fragmentTransaction.replace(R.id.place_holder, new FragmentProfile());
                                        fragmentTransaction.commit();
                                    } else {
                                        Log.e(TAG, "Failed:" + task.getException().toString());
                                        Toast.makeText(getActivity(), "Sign Up Failed",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });




                   // Realm.init(getActivity());
                    //Realm realm = Realm.getDefaultInstance();
                   // User user1 = realm.where(User.class).findFirst();
                    //realm.beginTransaction();
                    //realm.copyToRealm(user);
                    //realm.commitTransaction();


                }else if(password1.length()<8){
                    Toast.makeText(getActivity(),"Please your password is too short. Password should be at least characters", Toast.LENGTH_LONG).show();
                }
                else {

                    Toast.makeText(getActivity(), "Please check your passwords again. They do not match ", Toast.LENGTH_LONG).show();
                }

            }
        });

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.place_holder, new FragmentLogin());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
