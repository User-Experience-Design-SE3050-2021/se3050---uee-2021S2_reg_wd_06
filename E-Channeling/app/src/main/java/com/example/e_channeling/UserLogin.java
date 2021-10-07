package com.example.e_channeling;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserLogin extends AppCompatActivity implements View.OnClickListener{

    private TextView register;
    private EditText email,password;
    private Button loginBtn;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        email =findViewById(R.id.loginEmail);
        password =findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        register =findViewById(R.id.txtToRegister);
        progressBar =findViewById(R.id.progressBarLogin);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.txtToRegister):
                startActivity(new Intent(this, UserRegister.class));
                break;
            case (R.id.loginBtn):
                userLogin();
                break;

        }
    }

    private void userLogin(){
        String emailVal = email.getText().toString().trim();
        String passwordVal = password.getText().toString().trim();

        if(emailVal.isEmpty()){
            email.setError("Your email is required!");
            email.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(emailVal).matches()){
            email.setError("Provide valid email!");
            email.requestFocus();
        }
        if(passwordVal.isEmpty()){
            password.setError("Password is required!");
            password.requestFocus();
            return;
        }
        if(passwordVal.length()<6){
            password.setError("minimum password length 6 characters");
            password.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(emailVal,passwordVal).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(UserLogin.this,"You have been logged successfully!", Toast.LENGTH_LONG ).show();
                    progressBar.setVisibility(View.GONE);
                    startActivity(new Intent(UserLogin.this, HomeActivity.class));
                }else{
                    Toast.makeText(UserLogin.this,"Failed to Login!", Toast.LENGTH_LONG ).show();
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}