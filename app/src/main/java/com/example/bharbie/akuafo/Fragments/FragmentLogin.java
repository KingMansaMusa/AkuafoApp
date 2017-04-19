package com.example.bharbie.akuafo.Fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bharbie.akuafo.R;

/**
 * Created by BHARBIE on 4/16/2017.
 */

public class FragmentLogin extends Fragment {

    public FragmentLogin() {
    }

    EditText editTextEmail = (EditText) getView().findViewById(R.id.edit_text_email);
    EditText editTextPassword = (EditText) getView().findViewById(R.id.edit_text_password);
    Button buttonLogin = (Button) getView().findViewById(R.id.button_login);
    TextView textViewSignUp = (TextView) getView().findViewById(R.id.text_view_signup);
    TextView textViewForgotPassword = (TextView) getView().findViewById(R.id.text_view_forgot_password);

    Activity activity = getActivity();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);

        return view;

       /** buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                if (email == null) {
                    Toast.makeText(activity, "Please enter your email", Toast.LENGTH_LONG).show();
                } else {
                    if (password == null) {
                        Toast.makeText(activity, "Please enter your password", Toast.LENGTH_LONG).show();
                    } else {
                        getFragmentManager().beginTransaction().replace(R.id.place_holder, new Fragment()).commit();

                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        Fragment fragmentProfile = new FragmentProfile();
                        fragmentTransaction.replace(R.id.place_holder, fragmentProfile);
                        fragmentTransaction.commit();

                    }
                }


            }
        });**/

    }
}
