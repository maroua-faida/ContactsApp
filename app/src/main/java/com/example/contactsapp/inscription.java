package com.example.contactsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class inscription extends AppCompatActivity {
    EditText username;
    EditText password;
    EditText firstname;
    EditText lastname;
    EditText birthdate;
    String first_name;
    String last_name;
    String Username;
    String BirthDate;
    String Password;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("users");

    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);





        firstname=(EditText)findViewById(R.id.firstname_acc);
        lastname=(EditText)findViewById(R.id.lastname_acc);
        username=(EditText)findViewById(R.id.username_acc);
        birthdate=(EditText)findViewById(R.id.birthdate_acc);
        password=(EditText)findViewById(R.id.password_acc);



    }

    public void sign_up_acc(View view){
        first_name = firstname.getText().toString();
        last_name = lastname.getText().toString();
        Username = username.getText().toString();
        BirthDate = birthdate.getText().toString();
        Password = password.getText().toString();

        user user1 = new user(first_name,last_name, Username, BirthDate, Password);



        myRef.child(Username).setValue(user1);
        Toast.makeText(this,"User added successfully",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(inscription.this,MainActivity.class);

        startActivity(intent);

    }
}