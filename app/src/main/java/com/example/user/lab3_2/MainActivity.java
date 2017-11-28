package com.example.user.lab3_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinnerAge;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale, radioButtonFemale;
    private CheckBox checkBoxSmoker;
    private TextView textViewPremium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = (Spinner)findViewById(R.id.spinnerAge);
        //Create adapter to link to spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,R.array.age_group,android.R.layout.simple_spinner_item // system define res
        );
        adapter.setDropDownViewResource(
                android.R.layout.simple_dropdown_item_1line);
        spinnerAge.setOnItemSelectedListener(this);
        spinnerAge.setAdapter(adapter);

        spinnerAge = (Spinner) findViewById(R.id.spinnerAge);
        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroupGender);
        radioButtonMale = (RadioButton) findViewById(R.id.radioButtonMale);
        radioButtonFemale = (RadioButton) findViewById(R.id.radioButtonFemale);
        checkBoxSmoker = (CheckBox) findViewById(R.id.checkBoxSmoker);
        textViewPremium = (TextView) findViewById(R.id.textViewPremium);
    }

    @Override
    //parent is spinenr itself, view is individual
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),"Position:" + position,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void calculatePremium(View view){
        int pos;
        double premium=0;

        pos = spinnerAge.getSelectedItemPosition();
        switch (pos){
            case 1:
                premium = 50;
                break;
            case 2:
                premium = 55;
                break;
            case 3:
                premium = 60;
                break;
            case 4:
                premium = 70;
                break;
            case 5:
                premium = 120;
                break;
            case 6:
                premium = 160;
                break;
            case 7:
                premium = 200;
                break;
            case 8:
                premium = 250;
                break;
        }

        int indexGender = radioGroupGender.getCheckedRadioButtonId();
        if(indexGender == R.id.radioButtonMale){
            //TODO: calculate premium of male

        }else{
            //TODO: calculate premium of female
        }
        if(checkBoxSmoker.isChecked()){
            if(pos >=17){
                premium =+ 100;

            }else if(pos >= 22){
                premium =+ 150;

            }else if(pos >= 31){
                premium =+ 150;

            }else if(pos >= 41){
                premium =+ 250;

            }else
                premium =+ 250;
        }

        textViewPremium.setText(getString(R.string.premium) + premium);
    }
}
