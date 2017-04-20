package com.example.bharbie.akuafo.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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

/**
 * Created by BHARBIE on 4/16/2017.
 */

public class FragmentSignUp extends Fragment {

    public FragmentSignUp() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        final EditText editTextEmail = (EditText) view.findViewById(R.id.edit_text_signup_email);
        final EditText editTextName = (EditText) view.findViewById(R.id.edit_text_signup_username);
        final EditText editTextPassword = (EditText) view.findViewById(R.id.edit_text_signup_password);
        final EditText editTextPasswordAgain = (EditText) view.findViewById(R.id.edit_text_signup_password_again);
        final Spinner spinnerSignUp = (Spinner) view.findViewById(R.id.spinner_signup_type);
        Button buttonLogin = (Button) view.findViewById(R.id.button_signup);
        TextView textViewSignUp = (TextView) view.findViewById(R.id.text_view_login);


// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_options, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerSignUp.setAdapter(adapter);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                } else if (password1 != password2) {
                    Toast.makeText(getActivity(), "Please check your passwords again. They do not match ", Toast.LENGTH_LONG).show();
                } else {
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentProfile());
                    fragmentTransaction.commit();
                }

            }
        });

        textViewSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.place_holder, new FragmentProfile());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
