package com.example.week1weekend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    String input, output, number_one, currentOperator;
    double result, numberOne,temp;

    NumberFormat format,longfrmat;


    TextView tvinput;
    TextView tvOutput;

    Button btnSin;
    Button btnCos;
    Button btnTang;
    Button btnClear;
    Button btnparentheses;
    Button btnPercentage;
    Button btnDivision;
    Button btnLn;
    Button btnLog;
    Button btnRad;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btnMultiplication;
    Button btnePowx;
    Button btnxPow2;
    Button btn1OverX;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btnSubtraction;
    Button btnAbsolutVal;
    Button btnxPow3;
    Button btnFactorial;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btnAddition;
    Button btn2powx;
    Button btnSquareRoot;
    Button btnCubeRoot;
    Button btnSign;
    Button btn_0;
    Button btnDecimal;
    Button btnEqual;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning views
        tvinput = findViewById(R.id.tvinput);
        tvOutput = findViewById(R.id.tvoutput);
        tvinput.setMovementMethod(new ScrollingMovementMethod());

        format = new DecimalFormat("0.0000");

        //assigning buttons
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTang = findViewById(R.id.btnTang);
        btnClear = findViewById(R.id.btnClear);
        btnparentheses = findViewById(R.id.btnparentheses);
        btnPercentage = findViewById(R.id.btnPercentage);
        btnDivision = findViewById(R.id.btnDivision);
        btnLn = findViewById(R.id.btnLn);
        btnLog = findViewById(R.id.btnLog);
        btnRad = findViewById(R.id.btnRad);
        btn_7 = findViewById(R.id.btn_7 );
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9 );
        btnMultiplication = findViewById(R.id.btnMultiplication);
        btnePowx = findViewById(R.id.btnePowx);
        btnxPow2 = findViewById(R.id.btnxPow2);
        btn1OverX = findViewById(R.id.btn1OverX);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btnSubtraction = findViewById(R.id.btnSubtraction);
        btnAbsolutVal = findViewById(R.id.btnAbsolutVal);
        btnxPow3 = findViewById(R.id.btnxPow3);
        btnFactorial = findViewById(R.id.btnFactorial);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btnAddition = findViewById(R.id.btnAddition);
        btn2powx = findViewById(R.id.btn2powx);
        btnSquareRoot = findViewById(R.id.btnSquareRoot);
        btnCubeRoot = findViewById(R.id.btnCubeRoot);
        btnSign = findViewById(R.id.btnSign);
        btn_0 = findViewById(R.id.btn_0);
        btnDecimal = findViewById(R.id.btnDecimal);
        btnEqual = findViewById(R.id.btnEqual);

    }

    public void onButtonClickHandler(View view) {
        switch (view.getId()) {
            // numbers input
            case R.id.btn_0: stringManupulation("0");
                break;
            case R.id.btn_1: stringManupulation("1");
                break;
            case R.id.btn_2: stringManupulation("2");
                break;
            case R.id.btn_3: stringManupulation("3");
                break;
            case R.id.btn_4: stringManupulation("4");
                break;
            case R.id.btn_5: stringManupulation("5");
                break;
            case R.id.btn_6: stringManupulation("6");
                break;
            case R.id.btn_7: stringManupulation("7");
                break;
            case R.id.btn_8: stringManupulation("8");
                break;
            case R.id.btn_9: stringManupulation("9");
                break;
            case R.id.btnparentheses:char parenthese = checkParantheseDirectin();
                stringManupulation(String.valueOf(parenthese));
                break;
            case R.id.btnDecimal: stringManupulation(".");
                break;
            case R.id. btnClear: tvinput.setText("");
                tvOutput.setText("");
                tvinput.setText("");
                input = "";
                output = "";
                result = 0.0;
                temp = 0.0;
                numberOne = 0;
                updateCalculation();
                break;
            case R.id.btnPercentage: calculate("%");
                break;
            case R.id.btnDivision: stringManupulation("/"); ;
                break;
            case R.id.btnMultiplication: stringManupulation("*"); ;
                break;
            case R.id.btnAddition: stringManupulation("+"); ;
                break;
            case R.id.btnSubtraction: stringManupulation("-"); ;
                break;
//            case R.id.  ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
//            case R.id. ;
//                break;
            case R.id.btnSquareRoot: calculate("Ѵ") ;
                break;

        }
    }

    private void percentageClaculation() {
        output = Double.toString(Double.parseDouble(output)/100);

    }

    private char checkParantheseDirectin() {
        char paranthese = '(';
        if(input.equals("")) paranthese = '(';
        else if (input.charAt(input.length()-1) == '+') paranthese = '(';
        else if (input.charAt(input.length()-1) == '-') paranthese = '(';
        else if (input.charAt(input.length()-1) == '*') paranthese = '(';
        else if (input.charAt(input.length()-1) == '/') paranthese = '(';
        else paranthese = '(';
        return paranthese;
    }

    public void updateCalculation(){
        tvinput.setText(input);
        tvOutput.setText(output);

    }

    private void stringManupulation(String received) {

        input = tvinput.getText().toString()!= null ? tvinput.getText().toString() : "";
        input = input + received;
        //output = input;
        tvinput.setText(input);
        tvOutput.setText(output);
    }

    private void calculate(String received) {
        Double currentInput = Double.parseDouble(input);
        switch (received){
            case "+": result += currentInput;
                output = Double.toString(result);
                tvOutput.setText(output);
                break;
            case "/":result /= currentInput;
                output = Double.toString(result);
                tvOutput.setText(output);
                break;
            case "-":result -= currentInput;
                output = Double.toString(result);
                tvOutput.setText(output);
                break;
            case "*":
                break;
            case "%": result = currentInput/100;
                output = Double.toString(result);
                tvOutput.setText(output);

                break;
            case "=":
                break;
            case "sin":
                break;
            case "cos":
                break;
            case "tan":
                break;
            case "ln":
                break;
            case "log":
                break;
            case "rad":
                break;
            case "e^x":
                break;
            case "x^2":
                break;
            case "1/x":
                break;
            case "|x|":
                break;
            case "x^3":
                break;
            case "x!":
                break;
            case "2^x":
                break;
            case "Ѵ":
                break;

        }


    }


}
