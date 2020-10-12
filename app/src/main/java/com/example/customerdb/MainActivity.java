package com.example.customerdb;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton add_button;
    MyDatabaseHelper myDB;
    ArrayList<String> _id, customer_name, customer_company, customer_city, customer_phone, customer_email;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        add_button = findViewById(R.id.add_button);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);

            }
        });


        myDB = new MyDatabaseHelper(MainActivity.this);
        _id = new ArrayList<>();
        customer_name = new ArrayList<>();
        customer_company = new ArrayList<>();
        customer_city = new ArrayList<>();
        customer_phone = new ArrayList<>();
        customer_email = new ArrayList<>();

//_id, customer_name, customer_company, customer_city, customer_phone, customer_email
        storeDataInArrays();
        customAdapter = new CustomAdapter(MainActivity.this, this, _id, customer_name, customer_company, customer_city, customer_phone, customer_email);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }



    void storeDataInArrays () {
        Cursor cursor = myDB.readAllData();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                _id.add(cursor.getString(0));
                customer_name.add(cursor.getString(1));
                customer_company.add(cursor.getString(2));
                customer_city.add(cursor.getString(3));
                customer_phone.add(cursor.getString(4));
                customer_email.add(cursor.getString(5));
            }
        }
    }
}