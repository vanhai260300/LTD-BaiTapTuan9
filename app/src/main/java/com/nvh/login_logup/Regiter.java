package com.nvh.login_logup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Regiter extends AppCompatActivity {
    private TextView btlogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter2);
        btlogin= (TextView)   findViewById(R.id.txt_dn);
        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inten= new Intent(Regiter.this, LoginActivity.class);
                startActivity(inten);
            }
        });
    }
}