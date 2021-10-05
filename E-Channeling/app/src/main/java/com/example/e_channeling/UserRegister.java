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
import com.google.firebase.database.FirebaseDatabase;

public class UserRegister extends AppCompatActivity implements View.OnClickListener{

    private EditText name,age,city, email, password;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        TextView banner = findViewById(R.id.txtToRLogin);
        name=findViewById(R.id.uName);
        age=findViewById(R.id.uAge);
        city=findViewById(R.id.uCity);
        email=findViewById(R.id.uEamil);
        password=findViewById(R.id.uPassword);
        Button register = findViewById(R.id.registerBtn);
        progressBar= findViewById(R.id.progressBarRegister);

        banner.setOnClickListener(this);
        register.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.registerBtn:
                registerUser();
                break;
            case R.id.txtToRLogin:
                startActivity(new Intent(this, UserLogin.class));
                break;

        }
    }

    private void registerUser(){
        String nameVal = name.getText().toString().trim();
        String ageVal = age.getText().toString().trim();
        String cityVal = city.getText().toString().trim();
        String emailVal = email.getText().toString().trim();
        String passwordVal = password.getText().toString().trim();

        if(nameVal.isEmpty()){
            name.setError("Your name is required!");
            name.requestFocus();
            return;
        }

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
        if(ageVal.isEmpty()){
            age.setError("Your age is required!");
            age.requestFocus();
            return;
        }
        if(cityVal.isEmpty()){
            age.setError("Your city name is required!");
            age.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(emailVal,passwordVal)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                            User user = new User(nameVal,ageVal,cityVal,emailVal);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user)
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {

                                            if(task.isSuccessful()){
                                                Toast.makeText(UserRegister.this,"You have been registered successfully!", Toast.LENGTH_LONG ).show();
                                                progressBar.setVisibility(View.GONE);
                                                startActivity(new Intent(UserRegister.this, Home.class));
                                            }else{
                                                Toast.makeText(UserRegister.this,"Failed to register!", Toast.LENGTH_LONG ).show();
                                                progressBar.setVisibility(View.GONE);
                                            }
                                        }
                                    });
                        }else{
                            Toast.makeText(UserRegister.this,"Failed to register!", Toast.LENGTH_LONG ).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }

}