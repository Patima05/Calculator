package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Constants{

    private TextView textView;
    private Calculator calculator;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8, buttonC, buttonSign, buttonSettings,
            button9, buttonSum, buttonSubtract, buttonMultiply, buttonDivide, buttonSolve, buttonDot, buttonPercent, buttonBack;
    private static final int REQUEST_CODE_SETTINGS_ACTIVITY = 99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        calculator = new Calculator();
        textView = findViewById(R.id.textNumber);
        buttonC = findViewById(R.id.buttonC);
        buttonSign = findViewById(R.id.buttonSign);
        buttonPercent = findViewById(R.id.buttonPercent);
        buttonBack = findViewById(R.id.buttonBack);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot);
        buttonSum = findViewById(R.id.buttonSum);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonSolve = findViewById(R.id.buttonSolve);
        buttonSettings = findViewById(R.id.buttonSettings);
        initOnClickListeners();
    }

    private void initOnClickListeners() {
        textView = findViewById(R.id.textNumber);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonSum.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonSolve.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonSign.setOnClickListener(this);
        buttonBack.setOnClickListener(this);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSettings = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intentSettings);
                startActivityForResult(intentSettings, REQUEST_CODE_SETTINGS_ACTIVITY);

            }
        });
    }

    @Override
    public void onClick(View view) {

        String strValue = "";

        textView.setText("0");
        switch (view.getId()) {
            case R.id.button0: {
                strValue = calculator.setValueStr('0');
                break;
            }
            case R.id.button1: {
                strValue = calculator.setValueStr('1');
                break;
            }
            case R.id.button2: {
                strValue = calculator.setValueStr('2');
                break;
            }
            case R.id.button3: {
                strValue = calculator.setValueStr('3');
                break;
            }
            case R.id.button4: {
                strValue = calculator.setValueStr('4');
                break;
            }
            case R.id.button5: {
                strValue = calculator.setValueStr('5');
                break;
            }
            case R.id.button6: {
                strValue = calculator.setValueStr('6');
                break;
            }
            case R.id.button7: {
                strValue = calculator.setValueStr('7');
                break;
            }
            case R.id.button8: {
                strValue = calculator.setValueStr('8');
                break;
            }
            case R.id.button9: {
                strValue = calculator.setValueStr('9');
                break;
            }
            case R.id.buttonDot: {
                strValue = calculator.setValueStr('.');
                break;
            }
            case R.id.buttonSum: {
                strValue = String.valueOf(calculator.setOperator('+'));
                break;
            }
            case R.id.buttonSubtract: {
                strValue = String.valueOf(calculator.setOperator('-'));
                break;
            }
            case R.id.buttonMultiply: {
                strValue = String.valueOf(calculator.setOperator('*'));
                break;
            }
            case R.id.buttonDivide: {
                strValue = String.valueOf(calculator.setOperator('/'));
                break;
            }
            case R.id.buttonSolve: {
                strValue = String.valueOf(calculator.setOperator('='));
                break;
            }
            case R.id.buttonC: {
                strValue = String.valueOf(calculator.setOperator('c'));
                break;
            }
            case R.id.buttonPercent: {
                strValue = String.valueOf(calculator.setOperator('%'));
                break;
            }
            case R.id.buttonSign: {
                strValue = String.valueOf(calculator.setOperator('s'));
                break;
            }
            case R.id.buttonBack: {
                strValue = String.valueOf(calculator.setOperator('b'));
                break;
            }
            default:
                return;
        }
        textView.setText(strValue);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == RESULT_OK){
            super.onActivityResult(requestCode, resultCode, intent);
            return;
        }
        if (resultCode == RESULT_OK){
            int themeFromSettings = intent.getExtras().getInt(APP_THEME);
            setTheme(themeFromSettings);

        }

    }
}