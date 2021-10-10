package com.example.e_channeling;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.e_channeling.ui.claimRefund.ClaimRefundFragment;

import cn.pedant.SweetAlert.SweetAlertDialog ;

public class CreateRefund extends AppCompatActivity {

    EditText refNo,reason,holderName,bank,accNo;
    Button makeRefundBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_refund);

        refNo = findViewById(R.id.refNo);
        reason = findViewById(R.id.reason);
        holderName = findViewById(R.id.holderName);
        bank = findViewById(R.id.bank);
        accNo = findViewById(R.id.accNo);
        makeRefundBtn = findViewById(R.id.send);

        Intent i =new Intent(CreateRefund.this, ClaimRefundFragment.class);
//        i.putExtra("refNo", refNo.getText().toString());
//        i.putExtra("reason", reason.getText().toString());
//        i.putExtra("holderName", holderName.getText().toString());
//        i.putExtra("bank", bank.getText().toString());
//        i.putExtra("accNo", accNo.getText().toString());
        makeRefundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                new SweetAlertDialog(CreateRefund.this, SweetAlertDialog.SUCCESS_TYPE).setTitleText("Request Sent!").setContentText("Your request would be process before 3 days. ").setConfirmText("OK").setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {@Override
                public void onClick(SweetAlertDialog sDialog) {
                    // Showing simple toast message to user
                    startActivity(i);
                    sDialog.dismissWithAnimation();
                }
                }).show();
            }
        });

    }
}