package com.example.echannel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LicenseHospital extends AppCompatActivity {

    Button available;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_hospital);

                available = findViewById(R.id.available);

        available.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addQue = new Intent(LicenseHospital.this,LicenseForm.class);
                startActivity(addQue);
            }
        });

    }
}