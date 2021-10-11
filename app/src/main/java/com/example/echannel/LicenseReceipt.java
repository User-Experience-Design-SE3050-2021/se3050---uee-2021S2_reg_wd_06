package com.example.echannel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LicenseReceipt extends AppCompatActivity {
    Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_receipt);

        proceed=findViewById(R.id.booknow2);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addQue = new Intent(LicenseReceipt.this,makePayment.class);
                startActivity(addQue);
            }

        });
    }
}