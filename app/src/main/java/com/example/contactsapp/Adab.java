package com.example.contactsapp;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Adab extends RecyclerView.Adapter<Adab.MyViewHolder> {

    Context context;

    ArrayList<contact> list;
    DatabaseReference database;




    public Adab(Context context, ArrayList<contact> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.contact_item_layout,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        contact contact = list.get(position);
        holder.firstName.setText(contact.getFirst_name());
        holder.lastName.setText(contact.getLast_name());
        database = FirebaseDatabase.getInstance().getReference("contacts");

        // Add an onClickListener to the row
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), details_contact.class);
                intent.putExtra("contactId", contact.getKey());
                view.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView firstName, lastName ;
        ImageView delete;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.first);
            lastName = itemView.findViewById(R.id.last);
         //   delete=itemView.findViewById(R.id.delete);


        }
    }


}