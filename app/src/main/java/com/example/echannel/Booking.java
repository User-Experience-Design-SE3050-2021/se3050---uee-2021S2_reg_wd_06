package com.example.echannel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Booking extends AppCompatActivity {

    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);
        b1=findViewById(R.id.booknow);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnback();
            }
        });
    }
    public void returnback() {
        //Toast.makeText(getApplicationContext(), "Successfully added", Toast.LENGTH_SHORT).show();

        //call second activity
        Intent intent = new Intent(this, PayforBooking.class);
        startActivity(intent);

    }
}