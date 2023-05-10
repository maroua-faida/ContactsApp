package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ajouter_contact extends AppCompatActivity {

    EditText job;
    EditText email;
    EditText firstname;
    EditText lastname;
    EditText tel;
    String first_name;
    String last_name;
    String Job;
    String Tel;
    String Email;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("contacts");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_contact);


        firstname=(EditText)findViewById(R.id.firstname_add);
        lastname=(EditText)findViewById(R.id.lastname_add);
        job=(EditText)findViewById(R.id.job_add);
        tel=(EditText)findViewById(R.id.phone_add);
        email=(EditText)findViewById(R.id.email_add);
    }

    public void add_user(View view){



    first_name = firstname.getText().toString();
    last_name = lastname.getText().toString();
    Job = job.getText().toString();
    Email = email.getText().toString();
    Tel = tel.getText().toString();

    contact contact1 = new contact(first_name,last_name, Job, Email, Tel);



        myRef.child(Tel).setValue(contact1);
        Toast.makeText(this,"Contact added successfully",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(ajouter_contact.this,liste_contacts.class);

    startActivity(intent);
    }
}