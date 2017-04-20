package com.example.bharbie.akuafo.Fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.InputType;
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

public class FragmentLogin extends Fragment {

    public FragmentLogin() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        final EditText editTextEmail = (EditText) view.findViewById(R.id.edit_text_login_email);
        final EditText editTextPassword = (EditText) view.findViewById(R.id.edit_text_login_password);
        Button buttonLogin = (Button) view.findViewById(R.id.button_login);
        TextView textViewSignUp = (TextView) view.findViewById(R.id.text_view_signup);
        TextView textViewForgotPassword = (TextView) view.findViewById(R.id.text_view_forgot_password);

        editTextEmail.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS);



        Spinner spinnerLogin = (Spinner) view.findViewById(R.id.spinner_signup_type);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.spinner_options, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerLogin.setAdapter(adapter);



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your email", Toast.LENGTH_LONG).show();
                } else if (password.isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter your password", Toast.LENGTH_LONG).show();

                } else {

                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.place_holder, new FragmentProfile());
                    fragmentTransaction.commit();

                }
            }


        });

        // Intent intent = new Intent(getActivity(),AdsActivity.class);
        // startActivity(intent);

        textViewSignUp.setOnClickListener(new View.OnClickListener()

        {
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


