package com.example.bharbie.akuafo.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bharbie.akuafo.R;

public class PostTrucksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_trucks);

        final EditText editTextModel = (EditText)findViewById(R.id.post_trucks_model);
        final EditText editTextRegNo = (EditText)findViewById(R.id.post_trucks_reg_no);
        Button buttonPost = (Button)findViewById(R.id.button_post_truck);

        final Spinner spinnerTruckSize = (android.widget.Spinner)findViewById(R.id.spinner_truck_size);
        ArrayAdapter<CharSequence> adapterTruckSize = ArrayAdapter.createFromResource(PostTrucksActivity.this,
                R.array.spinner_truck_size, android.R.layout.simple_spinner_item);
        adapterTruckSize.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTruckSize.setAdapter(adapterTruckSize);

        buttonPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String model = editTextModel.getText().toString();
                String regNo = editTextRegNo.getText().toString();
                String size = spinnerTruckSize.getSelectedItem().toString();

                if (model.isEmpty()){
                    Toast.makeText(PostTrucksActivity.this,"Please specify the model of your truck",Toast.LENGTH_LONG);
                }else if (regNo.isEmpty()){
                    Toast.makeText(PostTrucksActivity.this,"Please input yout vehicle registration number",Toast.LENGTH_LONG);
                }else {
                    Intent intent = new Intent(PostTrucksActivity.this,HomeActivity.class);
                    intent.putExtra("Check",1);
                    startActivity(intent);
                }

            }
        });


    }
}
