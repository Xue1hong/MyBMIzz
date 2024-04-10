package com.example.mybmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText height;





    private EditText weight;
    private TextView show;

    private RadioGroup rgsex;


    private RadioButton rbMale;

    private RadioButton rbFeMale;
    
    private CheckBox cbA;
    private CheckBox cbB;
    private  CheckBox cbO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        rgsex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb1){
                    show.setText("我是男生");
                }
                else if(checkedId == R.id.rb2){
                    show.setText("我是女生");
                }
            }
        });
        
        cbA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getFruits();
            }
        });
        cbB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getFruits();
            }
        });
        cbO.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getFruits();
            }
        });
    }

    private void getFruits() {
        String msg = "";
        if(cbA.isChecked()){
            msg+="蘋狗";
        }
        if(cbB.isChecked()){
            msg+="香蕉";
        }
        if(cbO.isChecked()){
            msg+="橘子";
        }
        show.setText("我喜歡吃"+msg);
    }

    public void showDialog(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("BMI");
        double bmi = getBmi();
        String result = getString(R.string.strShowbmi)+bmi;
        builder.setMessage(result);
        builder.setPositiveButton("OK!", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which){
                Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show()  ;
    }


    public void calcBMI(View view) {

        double bmi = getBmi();

        String result = "your BMI is " + bmi;


        show.setText(result);

    }

    private double getBmi() {
        DecimalFormat df = new DecimalFormat("#.00");
        double h = Double.parseDouble(height.getText().toString());
        double w = Double.parseDouble(weight.getText().toString());
        double bmi = w / (h/100.0  * h /100.0);
        bmi = Double.parseDouble(df.format(bmi));
        return bmi;
    }

    private void findViews() {
        height = findViewById(R.id.etHeight);
        weight = findViewById(R.id.edWeight);
        show = findViewById(R.id.tvShow);
        rgsex = findViewById(R.id.rgsex);
        rbMale = findViewById(R.id.rb1);
        rbFeMale = findViewById(R.id.rb2);
        cbA = findViewById(R.id.cbA);
        cbB = findViewById(R.id.cbB);
        cbO = findViewById(R.id.cbO);

    }

    public void GoNext(View view) {
    Intent intent = new Intent(this, ResultActivity.class);
    double bmi = getBmi();
    intent.putExtra("bmi", bmi);
    startActivity(intent);
}
}