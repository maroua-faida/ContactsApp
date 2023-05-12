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

import com.bumptech.glide.Glide;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class  Adab extends RecyclerView.Adapter<Adab.MyViewHolder> {

    Context context;

    ArrayList<Contact> list;
    DatabaseReference database;




    public Adab(Context context, ArrayList<Contact> list) {
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

        Contact contact = list.get(position);
        holder.firstName.setText(contact.getFirst_name());
        holder.lastName.setText(contact.getLast_name());
        holder.job.setText(contact.getJob());
        database = FirebaseDatabase.getInstance().getReference("contacts");


        Glide.with(context).load(contact.getImage()).override(200, 200).into(holder.image);

        database = FirebaseDatabase.getInstance().getReference("users");


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
        TextView job;
        ImageView delete;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.first);
            lastName = itemView.findViewById(R.id.last);
            job = itemView.findViewById(R.id.job);

            image = itemView.findViewById(R.id.rImage);
          //  delete = itemView.findViewById(R.id.dImage);

         //  delete=itemView.findViewById(R.id.delete);


        }
    }

    private AlertDialog AskOption(Contact contact)
    {
        AlertDialog myQuittingDialogBox = new AlertDialog.Builder(context)
                // set message, title, and icon
                .setTitle("Supprimer")
                .setMessage("Etes vous sûr de vouloir supprimer cet utilisateur?")
                .setIcon(R.drawable.baseline_delete_24)
                .setPositiveButton("Supprimer", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {


                        database.child(contact.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {

                            @Override
                            public void onSuccess(Void unused) {

                                Intent intent= new Intent(context, liste_contacts.class);
                                context.startActivity(intent);
                                ((Activity)context).finish();
                                Toast.makeText(context, "Utilisateur supprimé", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(context, "deleted failed", Toast.LENGTH_SHORT).show();
                            }
                        });


                    }

                })
                .setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();

                    }
                })
                .create();

        return myQuittingDialogBox;

    }
}