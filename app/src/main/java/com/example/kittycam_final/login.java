package com.example.kittycam_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class login extends AppCompatActivity {

    EditText usermail,userpassowrd;
    Button login;
    private ProgressBar pb;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        usermail = (EditText)findViewById(R.id.editText);
        userpassowrd = (EditText)findViewById(R.id.editText2);
        login=(Button)findViewById(R.id.button4);
        pb = (ProgressBar)findViewById(R.id.progressBar2);
        ref = FirebaseDatabase.getInstance().getReference().child("Users");
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        pb.setVisibility(View.GONE);



    }

//
    private  void login(){
        final String mail =usermail.getText().toString();
        final String password =userpassowrd.getText().toString();
        Query query = ref.orderByChild("emailid").equalTo(mail);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot user : dataSnapshot.getChildren()) {

                        Users usersBean = user.getValue(Users.class);
                        pb.setVisibility(View.VISIBLE);
                        if (usersBean.passw.equals(password) ){
                            Intent intent=new Intent(login.this,page_home.class);
                            startActivity(intent);
                            Toast.makeText(login.this, "Login Successful", Toast.LENGTH_LONG).show();
                            pb.setVisibility(View.GONE);
                        } else {
                            Toast.makeText(login.this, "Incorrect Password", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(login.this, "User not found,Do Signup", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
