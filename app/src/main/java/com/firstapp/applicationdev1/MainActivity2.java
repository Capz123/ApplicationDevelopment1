package com.firstapp.applicationdev1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity2 extends AppCompatActivity {

    FirebaseAuth userAuth;
    TextView email;
    TextView password;
    ImageView GmailButton;
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        //createRequest();

        TextView register = (TextView) findViewById(R.id.register);

         email = (TextView) findViewById(R.id.email);
         password = (TextView) findViewById(R.id.password);

        Button login1 = (Button) findViewById(R.id.login);
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        userAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    startActivity(new Intent(MainActivity2.this, mainApp.class));
            }
        });
    }

    /* private void createRequest() {
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
    }*/

    private void loginUser()
    {
        String email1 = email.getText().toString();
        String password1 = password.getText().toString();

        if (TextUtils.isEmpty(email1)){
            email.setError("Email Cannot be empty");
            email.requestFocus();
        }
        else if (TextUtils.isEmpty(password1)) {
            password.setError("Password Cannot be empty");
            password.requestFocus();
        }
        else{
            userAuth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity2.this, "User logged in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity2.this,navigationDrawer_app.class));
                    }
                    else {
                        Toast.makeText(MainActivity2.this, "Log In Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}