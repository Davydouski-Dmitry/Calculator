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


    //прописываем константы
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task3);

        //Инициализация переменных
        tvOperand = findViewById(R.id.operandTextView);//первое значение в строке отображения (первое число)
        tvOperation = findViewById(R.id.operationTextView);//знак операции в строке отображения (+-*/)
        tvOperator = findViewById(R.id.operatorTextView);//второе значение в строке отображения(второе число)

        etResult =  findViewById(R.id.fieldEditText);//привязываем строку вывода

        //можем так книпки инициализировать
        //Button btnPlus = findViewById(R.id.btnPlus);
        //btnPlus.setOnClickListener(this);

        //но лучше так: + - * /
        findViewById(R.id.btnPlus).setOnClickListener(this);
        findViewById(R.id.btnMinus).setOnClickListener(this);
        findViewById(R.id.btnMulti).setOnClickListener(this);
        findViewById(R.id.btnDiv).setOnClickListener(this);
    }


    public void onClearClick(View view) {
        etResult.setText("");//очищаем поле ввода

        //очищаем все значения в строке отображения
        Button btn = (Button)view;
        String btnT = btn.getText().toString();

        if(btnT.equals("C")){
            tvOperand.setText("");
            tvOperation.setText("");
            tvOperator.setText("");
        }

    }

    public void onNumberClick(View view) {
        Button button = (Button) view; // btn2

        //1. получаем текс с кнопки
        String numberStr = button.getText().toString(); //"2"

        //2. set text to result edit text

        //3.получаем число с результата edit text
        String resultNumberStr = etResult.getText().toString(); //"10"

        //4. проверяем результат edit text number
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

    //метод реализующий расчёт в калькуляторе
    private double calculate() {

        String operandText = tvOperand.getText().toString();//получаем первое число
        double firstNumber = Double.parseDouble(operandText);//и преобразуем строку в число

        String operatorText = tvOperator.getText().toString();//получаем второе число
        double secondNumber = Double.parseDouble(operatorText);//и преобразуем строку в число

        //вычисляем результат в зависимости от оператора +-*/
        String operation = tvOperation.getText().toString();
        switch (operation){
            case ADDITION: return firstNumber+secondNumber;
            case SUBTRACTION: return firstNumber-secondNumber;
            case MULTIPLICATION: return firstNumber*secondNumber;
            case DIVISION: return firstNumber/secondNumber;
            default: return 0;
        }
    }

    @Override
    public void onClick(View v) {
        //1. запоминаем наш операнд
        String resultStr = etResult.getText().toString();
        tvOperand.setText(resultStr);

        //2. запоминаем операцию
        Button button = (Button) v;
        String operationStr = button.getText().toString();
        tvOperation.setText(operationStr);

        //3. очищаем поле ввода
        etResult.setText("");
    }
}