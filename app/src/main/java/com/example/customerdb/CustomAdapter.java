package com.example.customerdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList _id, customer_name, customer_company, customer_city, customer_phone, customer_email;

    CustomAdapter(Context context, ArrayList _id, ArrayList customer_name, ArrayList customer_company, ArrayList customer_city, ArrayList customer_phone, ArrayList customer_email) {
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder._id_txt.setText(String.valueOf(_id.get(position)));
        holder.customer_name_txt.setText(String.valueOf(customer_name.get(position)));
        holder.customer_company_txt.setText(String.valueOf(customer_company.get(position)));
        holder.customer_city_txt.setText(String.valueOf(customer_city.get(position)));
        holder.customer_phone_txt.setText(String.valueOf(customer_phone.get(position)));
        holder.customer_email_txt.setText(String.valueOf(customer_email.get(position)));



    }

    @Override
    public int getItemCount() {
        return _id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView _id_txt, customer_name_txt, customer_company_txt, customer_city_txt, customer_phone_txt, customer_email_txt;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            _id_txt = itemView.findViewById(R.id._id_txt);
            customer_name_txt = itemView.findViewById(R.id.customer_name_txt);
            customer_company_txt = itemView.findViewById(R.id.customer_company_txt);
            customer_city_txt = itemView.findViewById(R.id.customer_city_txt);
            customer_phone_txt = itemView.findViewById(R.id.customer_phone_txt);
            customer_email_txt = itemView.findViewById(R.id.customer_email_txt);

        }
    }
}
