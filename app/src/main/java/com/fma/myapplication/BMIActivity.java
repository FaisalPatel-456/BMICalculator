package com.fma.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Objects;

public class BMIActivity extends AppCompatActivity {

    private android.widget.Button recalculateBMIBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        Objects.requireNonNull(getSupportActionBar()).hide();

        recalculateBMIBtn = findViewById(R.id.recalculate_bmi_button);

        recalculateBMIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}