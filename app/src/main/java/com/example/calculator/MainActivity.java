package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Calculator calculator;
    private Button button0, button1, button2, button3, button4, button5, button6, button7, button8,
            button9, buttonSum, buttonSubtract, buttonMultiply, buttonDivide, buttonSolve, buttonDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        calculator = new Calculator();
        textView = findViewById(R.id.textNumber);
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
    }

    @Override
    public void onClick(View view) {

        String strValue = "";
        textView.setText("hello");
        switch (view.getId()) {
            case R.id.button0: {
                strValue = calculator.setValueStrInc('0');
                break;
            }
            case R.id.button1: {
                strValue = calculator.setValueStrInc('1');
                break;
            }
            case R.id.button2: {
                strValue = calculator.setValueStrInc('2');
                break;
            }
            case R.id.button3: {
                strValue = calculator.setValueStrInc('3');
                break;
            }
            case R.id.button4: {
                strValue = calculator.setValueStrInc('4');
                break;
            }
            case R.id.button5: {
                strValue = calculator.setValueStrInc('5');
                break;
            }
            case R.id.button6: {
                strValue = calculator.setValueStrInc('6');
                break;
            }
            case R.id.button7: {
                strValue = calculator.setValueStrInc('7');
                break;
            }
            case R.id.button8: {
                strValue = calculator.setValueStrInc('8');
                break;
            }
            case R.id.button9: {
                strValue = calculator.setValueStrInc('9');
                break;
            }
            case R.id.buttonDot: {
                strValue = calculator.setValueStrInc('.');
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
            default:
                return;
        }
        textView.setText(strValue);

    }
}