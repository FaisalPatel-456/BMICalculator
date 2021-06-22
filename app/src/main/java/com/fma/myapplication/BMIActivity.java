package com.fma.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Objects;

public class BMIActivity extends AppCompatActivity {

    private android.widget.Button recalculateBMIBtn;
    private TextView bmiDisplay;
    private TextView bmiCategory;
    private TextView gender;
    private Intent intent;
    private ImageView imageView;
    private String bmi;
    private float intbmi;
    private String height;
    private String weight;
    private float intheight;
    private float intweight;
    private RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_m_i);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\">"));
        getSupportActionBar().setTitle("Result");

        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        intent = getIntent();
        bmiDisplay = findViewById(R.id.bmi_display);
        bmiCategory = findViewById(R.id.bmi_catagory);
        gender = findViewById(R.id.gender_display);
        background = findViewById(R.id.content_layout);
        imageView = findViewById(R.id.result_image);
        recalculateBMIBtn = findViewById(R.id.recalculate_bmi_button);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight/100;
        intbmi = intweight/(intheight*intheight);

        bmi = Float.toString(intbmi);

        if(intbmi < 16){

            bmiCategory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.crosss);
        }
        else if(intbmi < 16.9 && intbmi > 16){

            bmiCategory.setText("Moderate Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if(intbmi < 18.4 && intbmi > 17){

            bmiCategory.setText("Mild Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.warning);
        }
        else if(intbmi < 25 && intbmi > 18.4){

            bmiCategory.setText("Normal");
            //background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.ok);
        }
        else if(intbmi < 29.4 && intbmi > 25){

            bmiCategory.setText("Overweight");
            background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.warning);
        }
        else{

            bmiCategory.setText("Obsessed");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.crosss);
        }

        gender.setText(intent.getStringExtra("gender"));
        bmiDisplay.setText(bmi);

        recalculateBMIBtn = findViewById(R.id.recalculate_bmi_button);

        recalculateBMIBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}