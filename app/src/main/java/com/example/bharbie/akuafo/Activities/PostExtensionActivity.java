package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bharbie.akuafo.R;

public class PostExtensionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_extension);

        final EditText editTextHeading = (EditText)findViewById(R.id.post_extension_heading);
        final EditText editTextInfo = (EditText)findViewById(R.id.post_extension_info);
        Button buttonPost = (Button)findViewById(R.id.post_extension_button);

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String heading = editTextHeading.getText().toString();
                String info = editTextInfo.getText().toString();

                if (heading.isEmpty()){
                    Toast.makeText(PostExtensionActivity.this,"Please give a heading to your post",Toast.LENGTH_LONG);
                }else if (info.isEmpty()){
                    Toast.makeText(PostExtensionActivity.this,"Please input your extension information",Toast.LENGTH_LONG);
                }else{
                    Intent intent = new Intent(PostExtensionActivity.this,HomeActivity.class);
                    startActivity(intent);
                }

            }
        });


    }
}
