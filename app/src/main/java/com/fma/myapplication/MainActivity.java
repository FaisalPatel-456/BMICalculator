package com.fma.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button calculateBMIBtn;
    private SeekBar seekBar;
    private TextView currentHeight;
    private TextView currentAge;
    private TextView currentWeight;
    private ImageView incrementAge;
    private ImageView decrementAge;
    private ImageView incrementWeight;
    private ImageView decrementWeight;

    private RelativeLayout male, female;
    private int intWeight = 55;
    private int intAge = 22;
    private int currentProgress;
    private String intProgress = "170";
    private String typeOfUser = "0";
    private String weight2 = "55";
    private String age2 = "22";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        calculateBMIBtn = findViewById(R.id.calculate_bmi_button);
        currentAge = findViewById(R.id.current_age);
        currentWeight = findViewById(R.id.current_weight);
        currentHeight = findViewById(R.id.current_hieght);
        incrementAge = findViewById(R.id.increment_age);
        decrementAge = findViewById(R.id.decrement_age);
        incrementWeight = findViewById(R.id.increment_weight);
        decrementWeight = findViewById(R.id.decrement_weight);
        seekBar = findViewById(R.id.seekbar_hieght);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gender_focus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gender_unfocus));
                typeOfUser = "Male";
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gender_focus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.gender_unfocus));
                typeOfUser = "Female";
            }
        });

        seekBar.setMax(250);
        seekBar.setProgress(170);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                currentProgress = progress;
                intProgress = String.valueOf(currentProgress);
                currentHeight.setText(intProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        incrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge++;
                age2 = String.valueOf(intAge);
                currentAge.setText(age2);
            }
        });

        decrementAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intAge--;
                age2 = String.valueOf(intAge);
                currentAge.setText(age2);
            }
        });

        incrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight++;
                weight2 = String.valueOf(intWeight);
                currentWeight.setText(weight2);
            }
        });

        decrementWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intWeight--;
                weight2 = String.valueOf(intWeight);
                currentWeight.setText(weight2);
            }
        });

        calculateBMIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(typeOfUser.equals("0")){

                    Toast.makeText(getApplicationContext(), "Select gender first", Toast.LENGTH_SHORT).show();

                } else if(intProgress.equals("0")){

                    Toast.makeText(getApplicationContext(), "Select valid height first", Toast.LENGTH_SHORT).show();

                } else if(intAge == 0 || intAge < 0){

                    Toast.makeText(getApplicationContext(), "Select valid age first", Toast.LENGTH_SHORT).show();

                } else if(intWeight == 0 || intWeight < 0) {

                    Toast.makeText(getApplicationContext(), "Select valid weight first", Toast.LENGTH_SHORT).show();

                } else {

                    Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                    intent.putExtra("gender", typeOfUser);
                    intent.putExtra("height", intProgress);
                    intent.putExtra("weight", weight2);
                    intent.putExtra("Age", age2);
                    startActivity(intent);
                }
            }
        });
    }
}