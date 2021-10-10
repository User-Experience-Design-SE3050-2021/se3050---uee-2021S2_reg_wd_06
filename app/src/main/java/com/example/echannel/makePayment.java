package com.example.echannel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class makePayment extends AppCompatActivity {
    Button paybutton;
    Dialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_payment);
        paybutton = findViewById(R.id.paybutton8);
        dialog = new Dialog(this);
        paybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSuccessDialog();
            }
        });


    }

    private void openSuccessDialog() {
        dialog.setContentView(R.layout.payment_sucess);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView imageViewClose = dialog.findViewById(R.id.closeimg);
        Button btnOk = dialog.findViewById(R.id.btnOKpayment);

        imageViewClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(makePayment.this,"Dialog close",Toast.LENGTH_SHORT).show();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                Toast.makeText(makePayment.this,"Button OK",Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}