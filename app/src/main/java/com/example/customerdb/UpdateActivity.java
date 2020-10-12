package com.example.customerdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText name_input, company_input, city_input, phone_input, email_input;
    Button update_button;
    String id, name, company, city, phone, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name_input = findViewById(R.id.name_input2);
        company_input = findViewById(R.id.company_input2);
        city_input = findViewById(R.id.city_input2);
        phone_input = findViewById(R.id.phone_input2);
        email_input = findViewById(R.id.email_input2);
        update_button = findViewById(R.id.update_button);

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.dataUpdate(id, name, company, city, phone, email); // tätä kutsutaan viimeiseksi

            }

        });


    }


    void getAndSetIntentData(){
        if (getIntent().hasExtra("id") && getIntent().hasExtra("name") && getIntent().hasExtra("company")
                && getIntent().hasExtra("city") && getIntent().hasExtra("phone") && getIntent().hasExtra("email")){
            id = getIntent().getStringExtra("id");
            name = getIntent().getStringExtra("name");
            company = getIntent().getStringExtra("company");
            city = getIntent().getStringExtra("city");
            phone = getIntent().getStringExtra("phone");
            email = getIntent().getStringExtra("email");

            name_input.setText(name);
            company_input.setText(company);
            city_input.setText(city);
            phone_input.setText(phone);
            email_input.setText(email);

        }else {
            Toast.makeText(this, "No data!", Toast.LENGTH_SHORT).show();
        }
    }
}