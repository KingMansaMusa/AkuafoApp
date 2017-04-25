package com.example.bharbie.akuafo.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static android.content.ContentValues.TAG;

/**
 * Created by BHARBIE on 4/16/2017.
 */

public class FragmentLogin extends Fragment {

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;


    EditText editTextEmail, editTextPassword;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mDatabase = FirebaseDatabase.getInstance().getReference().child("UserTable");
        mAuth = FirebaseAuth.getInstance();


        View view = inflater.inflate(R.layout.fragment_login, container, false);

        editTextEmail = (EditText) view.findViewById(R.id.edit_text_login_email);
        editTextPassword = (EditText) view.findViewById(R.id.edit_text_login_password);
        Button buttonLogin = (Button) view.findViewById(R.id.button_login);
        TextView textViewSignUp = (TextView) view.findViewById(R.id.text_view_signup);



        final Spinner spinnerLogin = (Spinner) view.findViewById(R.id.spinner_login_type);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_login, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerLogin.setAdapter(adapter);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = spinnerLogin.getSelectedItem().toString();
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your email", Toast.LENGTH_LONG).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your password", Toast.LENGTH_LONG).show();

                } else {
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Log.d(TAG, "signIn:onComplete:" + task.isSuccessful());

                                    if (task.isSuccessful()) {

                                        UserInfo userInfo = task.getResult().getUser();
                                        String email = userInfo.getEmail();
                                        String id = userInfo.getUid();
                                        mDatabase.child(id).addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                UserFire userFire = dataSnapshot.getValue(UserFire.class);
                                                User user = new User(userFire.id,userFire.name,userFire.email,userFire.password,userFire.type);
                                                user.save(user);
                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }
                                        });
                                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                                        fragmentTransaction.replace(R.id.place_holder, new FragmentProfile());
                                        fragmentTransaction.commit();

                                    } else {
                                        Toast.makeText(getActivity(), "Login Failed. Your credentials do not exist. Check your credentials or Sign Up",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });



                }
            }


        });

        // Intent intent = new Intent(getActivity(),AdsActivity.class);
        // startActivity(intent);

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.place_holder, new FragmentSignUp());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}


