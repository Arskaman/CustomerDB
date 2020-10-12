package com.example.customerdb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList _id, customer_name, customer_company, customer_city, customer_phone, customer_email;
   // int position;

    CustomAdapter(Activity activity, Context context, ArrayList _id, ArrayList customer_name, ArrayList customer_company, ArrayList customer_city, ArrayList customer_phone, ArrayList customer_email) {
        this.activity = activity;
        this.context = context;
        this._id = _id;
        this.customer_name = customer_name;
        this.customer_company = customer_company;
        this.customer_city = customer_city;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        //this.position = position; //Update
        holder._id_txt.setText(String.valueOf(_id.get(position)));
        holder.customer_name_txt.setText(String.valueOf(customer_name.get(position)));
        holder.customer_company_txt.setText(String.valueOf(customer_company.get(position)));
        holder.customer_city_txt.setText(String.valueOf(customer_city.get(position)));
        holder.customer_phone_txt.setText(String.valueOf(customer_phone.get(position)));
        holder.customer_email_txt.setText(String.valueOf(customer_email.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() { //Update
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(_id.get(position)));
                intent.putExtra("name", String.valueOf(customer_name.get(position)));
                intent.putExtra("company", String.valueOf(customer_company.get(position)));
                intent.putExtra("city", String.valueOf(customer_city.get(position)));
                intent.putExtra("phone", String.valueOf(customer_phone.get(position)));
                intent.putExtra("email", String.valueOf(customer_email.get(position)));
                activity.startActivityForResult(intent,1); // nyt refressaa
            }
        });



    }

    @Override
    public int getItemCount() {
        return _id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView _id_txt, customer_name_txt, customer_company_txt, customer_city_txt, customer_phone_txt, customer_email_txt;
        LinearLayout mainLayout; //Update

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            _id_txt = itemView.findViewById(R.id._id_txt);
            customer_name_txt = itemView.findViewById(R.id.customer_name_txt);
            customer_company_txt = itemView.findViewById(R.id.customer_company_txt);
            customer_city_txt = itemView.findViewById(R.id.customer_city_txt);
            customer_phone_txt = itemView.findViewById(R.id.customer_phone_txt);
            customer_email_txt = itemView.findViewById(R.id.customer_email_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout); // Update

        }
    }
}
