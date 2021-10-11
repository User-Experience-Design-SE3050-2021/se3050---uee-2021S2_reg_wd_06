package com.example.echannel;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LicenseMedical extends AppCompatActivity {
    private Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license_medical);
        book = findViewById(R.id.book1);
        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addQue = new Intent(LicenseMedical.this,LicenseHospital.class);
                startActivity(addQue);
        }

        });

    }
}