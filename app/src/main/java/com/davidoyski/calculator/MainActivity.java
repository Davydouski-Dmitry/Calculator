package com.davidoyski.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvOperand;
    private TextView tvOperation;
    private TextView tvOperator;

    private EditText etResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task3);

        tvOperand = findViewById(R.id.operandTextView);
        tvOperation = findViewById(R.id.operationTextView);
        tvOperator = findViewById(R.id.operatorTextView);

        etResult =  findViewById(R.id.fieldEditText);

        //Button btnPlus = findViewById(R.id.btnPlus);
        //btnPlus.setOnClickListener(this);

        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnMulti).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
    }


    public void onClearClick(View view) {

    }

    public void onNumberClick(View view) {
        Button button = (Button) view; // btn2

        //1. get text from button
        String numberStr = button.getText().toString(); //"2"

        //2. set text to result edit text

        //3. get number from result edit text
        String resultNumberStr = etResult.getText().toString(); //"10"

        //4. check result edit text number
        if (resultNumberStr.equals("0")) { // false
            etResult.setText(numberStr);
        } else {
            etResult.append(numberStr); // "102"
        }
    }

    public void onEqualsClick(View view) {
        //1. from result edit text to operator text view
        String resultStr = etResult.getText().toString();
        tvOperator.setText(resultStr);

        //2. calculate
        double result = calculate();

        //3. set result to result edit text
        resultStr = String.valueOf(result);
        etResult.setText(resultStr);
    }

    private double calculate() {
        //actions
        return 0;
    }

    @Override
    public void onClick(View v) {
        //1. from result edit text to operand text view
        String resultStr = etResult.getText().toString();
        tvOperand.setText(resultStr);

        //2. from pressed button to operation text view
        Button button = (Button) v;
        String operationStr = button.getText().toString();
        tvOperation.setText(operationStr);

        //3. clear result edit text
        etResult.setText("");
    }
}