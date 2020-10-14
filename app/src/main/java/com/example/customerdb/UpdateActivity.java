package com.example.customerdb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText name_input, company_input, city_input, phone_input, email_input;
    Button update_button, delete_button; //delete button vaihe1
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
        delete_button = findViewById(R.id.delete_button); //delete button vaihe2

        getAndSetIntentData();

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                name = name_input.getText().toString().trim();
                company = company_input.getText().toString().trim();
                city = city_input.getText().toString().trim();
                phone = phone_input.getText().toString().trim();
                email = email_input.getText().toString().trim();
                myDB.dataUpdate(id, name, company, city, phone, email);// tätä kutsutaan viimeisekksi
            }

        });
        delete_button.setOnClickListener(new View.OnClickListener() { //delete button vaihe3
            @Override
            public void onClick(View view) {
                confirmDialog();



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
    void confirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + name + "?");
        builder.setMessage("Are you sure you want to delete" + name + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id); //Kun painetaan Yes
                finish(); // palataan takasin alkunäkymään

            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }


}