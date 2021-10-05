package com.example.e_channeling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class UserLogin extends AppCompatActivity implements View.OnClickListener{

    private TextView register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        register =findViewById(R.id.txtToRegister);
        register.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case (R.id.txtToRegister):
                startActivity(new Intent(this, UserRegister.class));
                break;


        }
    }
}