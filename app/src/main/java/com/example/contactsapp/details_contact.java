package com.example.contactsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class details_contact extends AppCompatActivity {

    private DatabaseReference database;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_details_contact);

        // Get the contact's key from the Intent
        String contactId = getIntent().getStringExtra("contactId");

        // Get a reference to the contacts node in the database
        database = FirebaseDatabase.getInstance().getReference("contacts");

        // Query the database for the contact with the specified key
        Query query = database.child(contactId);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Check if the contact exists in the database
                if (snapshot.exists()) {
                    // Retrieve the contact object from the snapshot
                    Contact contact = snapshot.getValue(Contact.class);

                    // Update the UI with the contact details
                    TextView firstNameTextView = findViewById(R.id.first);
                    firstNameTextView.setText(contact.getFirst_name());
                    TextView lastNameTextView = findViewById(R.id.last);
                    lastNameTextView.setText(contact.getLast_name());
                    TextView job = findViewById(R.id.job);
                    job.setText(contact.getJob());




                } else {
                    // Handle the case where the contact doesn't exist in the database
                    Toast.makeText(details_contact.this, "Contact not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle the database query being cancelled
                Toast.makeText(details_contact.this, "Error retrieving contact details", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


