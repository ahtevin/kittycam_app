package com.example.kittycam_final;

import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;





public class sign_up extends AppCompatActivity {

    private EditText name, email, pass, number;
    private Button signup;
    private ProgressBar pb;
    private boolean a;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        name=(EditText) findViewById(R.id.editText4);
        email=(EditText) findViewById(R.id.editText6);
        pass=(EditText) findViewById(R.id.editText5);
        number=(EditText) findViewById(R.id.editText4);
        signup=(Button) findViewById(R.id.button2);
        pb=(ProgressBar) findViewById(R.id.progressBar);
        pb.setVisibility(View.GONE);
        auth=FirebaseAuth.getInstance();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });


    }

    private void register() {
        final String username=name.getText().toString().trim();
        final String usermail=email.getText().toString().trim();
        final String number1=number.getText().toString().trim();
        final String password=pass.getText().toString().trim();

        if (username.isEmpty()) {
            Toast.makeText(this, "Please enter name ", Toast.LENGTH_LONG).show();
            return;
        }
        if (usermail.isEmpty()) {
            Toast.makeText(this, "Please enter email ", Toast.LENGTH_LONG).show();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(usermail).matches()){
            Toast.makeText(this,"Please enter a valid email",Toast.LENGTH_LONG).show();

            return;
        }
        if (number1.isEmpty()) {
            Toast.makeText(this, "Please enter Mobilenumber ", Toast.LENGTH_LONG).show();
            return;
        }
        if(number1.length()<10){
            Toast.makeText(this, "Please enter a valid number ", Toast.LENGTH_LONG).show();
            return;

        }
        if (password.isEmpty()) {
            Toast.makeText(this, "Please enter password ", Toast.LENGTH_LONG).show();
            return;
        }
        if (password.length() < 6) {
            Toast.makeText(this, "Password should be atleast 6 characters long", Toast.LENGTH_LONG).show();

            return;
        }

            pb.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(usermail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Users user=new Users(username, usermail, password, number1);

                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            pb.setVisibility(View.GONE);
                            if (task.isSuccessful()) {
                                Toast.makeText(sign_up.this, "Signup Successfull", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(sign_up.this, login.class);
                                startActivity(intent);

                            } else {
                                Toast.makeText(sign_up.this, "Registration Failed,Try Again", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(sign_up.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}







