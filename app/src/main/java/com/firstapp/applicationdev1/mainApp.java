package com.firstapp.applicationdev1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class mainApp extends AppCompatActivity {

    TextView username;
    TextView email1;
    TextView password;
    TextView repass;
    Button reg;
    FirebaseAuth userAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_app);
        getSupportActionBar().hide();

        username = (TextView) findViewById(R.id.username2);
        email1 = (TextView) findViewById(R.id.email1);
        password = (TextView) findViewById(R.id.password2);
        repass = (TextView) findViewById(R.id.password3);

        reg = (Button) findViewById(R.id.register1);

        userAuth = FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });
    }
    private void createUser(){
        String email = email1.getText().toString();
        String password1 = password.getText().toString();

        if (TextUtils.isEmpty(email)){
            email1.setError("Email Cannot be empty");
            email1.requestFocus();
        }
        else if (TextUtils.isEmpty(password1)) {
            email1.setError("Password Cannot be empty");
            email1.requestFocus();
        }
        else{
            userAuth.createUserWithEmailAndPassword(email,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(mainApp.this, "User Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(mainApp.this,MainActivity2.class));
                    }
                    else{
                        Toast.makeText(mainApp.this, "Registration Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}