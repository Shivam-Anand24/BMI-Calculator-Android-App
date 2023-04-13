package com.example.bmicalci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.math.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt,edtHeightIn, edtAge;
        TextView txtResult;
        Button calcBmi;
        ConstraintLayout clmain;

        edtWeight =findViewById(R.id.weight);
        edtHeightFt=findViewById(R.id.heightFt);
        edtHeightIn=findViewById(R.id.heightIn);

        calcBmi=findViewById(R.id.bmiButton);
        txtResult=findViewById(R.id.textResult);
        clmain=findViewById(R.id.clmain);

        calcBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double wt= Integer.parseInt( edtWeight.getText().toString());
                int ft= Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn=ft*12+in;

                double totalCm=totalIn*2.53;

                double totalM=totalCm/100;

                double bmi =wt/(Math.pow(totalM,2));
            bmi=  Math.round(bmi*100.0)/100.0;
                if(bmi>25)
                {
                    txtResult.setText("Your BMI is " +bmi+ " and You're Overweight");
                    clmain.setBackgroundColor(getResources().getColor(R.color.colorOw));
                }
                else if (bmi<18)
                {
                    txtResult.setText("Your BMI is " +bmi+ " and You're Underweight");
                    clmain.setBackgroundColor(getResources().getColor(R.color.colorUn));
                }
                else
                {
                    txtResult.setText("Your BMI is " +bmi+ " and You're Healthy & Normal");
                    clmain.setBackgroundColor(getResources().getColor(R.color.colorN));
                }
            }
        });
    }
}