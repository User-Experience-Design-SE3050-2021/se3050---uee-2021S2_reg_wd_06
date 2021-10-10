package com.example.echannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PcrReciept extends AppCompatActivity {
Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcr_reciept);
        proceed = findViewById(R.id.btnProceed);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addQue = new Intent(PcrReciept.this,checkout.class);
                startActivity(addQue);
            }
        });
    }
}