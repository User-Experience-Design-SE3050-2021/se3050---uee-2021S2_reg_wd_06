package com.example.echannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class checkout extends AppCompatActivity {
        Button payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        payment = findViewById(R.id.button8);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addQue = new Intent(checkout.this,makePayment.class);
                startActivity(addQue);
            }
        });
    }
}