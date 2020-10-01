package com.example.customerdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText name_input, company_input, city_input, phone_input, email_input;
    Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
//kenttien id:t ja kuuntelija napille
        name_input = findViewById(R.id.name_input);
        company_input = findViewById(R.id.company_input);
        city_input = findViewById(R.id.city_input);
        phone_input = findViewById(R.id.phone_input);
        email_input = findViewById(R.id.email_input);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override // kun nappia painetaan
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.addCustomer(name_input.getText().toString().trim(),
                        company_input.getText().toString().trim(),
                        city_input.getText().toString().trim(),
                        phone_input.getText().toString().trim(),
                        email_input.getText().toString().trim());
            }
        });

    }
}