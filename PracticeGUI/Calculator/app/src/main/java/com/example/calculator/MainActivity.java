package com.example.calculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Stack;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnOpen, btnClose, btnCancel, btnAllCancel, btn1, btn2, btn3, btn4, btn5, btn6,
            btn7, btn8, btn9, btn0, btnDot, btnEqual, btnPlus, btnSubtract, btnMulti, btnDivide;
    TextView txtExpression, txtResult;
    String express = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        calProcess();
    }

    private void getID() {
        btnOpen = findViewById(R.id.btnOpen);
        btnClose = findViewById(R.id.btnClose);
        btnCancel = findViewById(R.id.btnCancel);
        btnAllCancel = findViewById(R.id.btnAllCancel);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);
        btnPlus = findViewById(R.id.btnPlus);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMulti = findViewById(R.id.btnMulti);
        btnDivide = findViewById(R.id.btnDivide);

        txtExpression = findViewById(R.id.txtExpression);
        txtResult = findViewById(R.id.txtResult);
    }

    private void calProcess() {
        getID();
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "(");
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + ")");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "9");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "0");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + ".");
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "+");
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "-");
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "x");
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                txtExpression.setText(express + "/");
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = txtExpression.getText().toString();
                if (!temp.isEmpty()) {
                    temp = temp.substring(0, temp.length() - 1);
                    txtExpression.setText(temp);
                }
            }
        });

        btnAllCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtExpression.setText("");
                txtResult.setText("");
                express = "";
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                express = txtExpression.getText().toString();
                express=express.replace("x", "*");
                try {
                    txtResult.setText(String.valueOf(evaluate(express)));
                } catch (Exception e) {
                    txtResult.setText("Error");

                }
            }
        });
    }

    private boolean priority(char o1, char o2) {
        if (o2 == '(' || o2 == ')')
            return false;
        if ((o1 == '*' || o1 == '/') && (o2 == '+' || o2 == '-'))
            return false;
        else return true;
    }

    private double caculate(char o, double b, double a) {
        switch (o) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Error: Cannot divide by 0");
                }
                return a / b;
        }
        return 0;
    }

    private double evaluate(String express) {
        char c[] = express.toCharArray();

        Stack<Double> number = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') continue;
            if (c[i] >= '0' && c[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < c.length && (c[i] >= '0' && c[i] <= '9' || c[i] == '.'))
                    sb.append(c[i++]);
                number.push(Double.parseDouble(sb.toString()));
                i--;
            } else if (c[i] == '(') {
                operator.push(c[i]);
            } else if (c[i] == ')') {
                while (operator.peek() != '(')
                    number.push(caculate(operator.pop(), number.pop(), number.pop()));
                operator.pop();
            } else if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/') {
                while (!operator.empty() && priority(c[i], operator.peek()))
                    number.push(caculate(operator.pop(), number.pop(), number.pop()));
                operator.push(c[i]);
            }
        }
        while (!operator.empty())
            number.push(caculate(operator.pop(), number.pop(), number.pop()));
        return number.pop();
    }
//    private double evaluate(String expression) {
//        char c[] = expression.toCharArray();
//        Stack<Double> number = new Stack<>();
//        Stack<Character> operator = new Stack<>();
//
//        for (int i = 0; i < c.length; i++) {
//            if (c[i] == ' ') {
//                continue;
//            }
//            if (c[i] >= '0' && c[i] <= '9') {
//                StringBuilder sb = new StringBuilder();
//                while (i < c.length && (c[i] >= '0' && c[i] <= '9' || c[i] == '.'))
//                    sb.append(c[i++]);
//                number.push(Double.parseDouble(sb.toString()));
//                i--;
//            } else if (c[i] == '(') {
//                operator.push(c[i]);
//            } else if (c[i] == ')') {
//                while (operator.peek() != '(')
//                    number.push(calulate(operator.pop(), number.pop(), number.pop()));
//                operator.pop();
//            } else if (c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/') {
//                while (!operator.empty() && priority(c[i], operator.peek()))
//                    number.push(calulate(operator.pop(), number.pop(), number.pop()));
//                operator.push(c[i]);
//            }
//        }
//        while (!operator.empty()) {
//            number.push(calulate(operator.pop(), number.pop(), number.pop()));
//        }
//        return number.pop();
//    }
//
//    private boolean priority(char o1, char o2) {
//        if (o2 == '(' || o2 == ')') {
//            return false;
//        }
//        if ((o1 == '*' || o1 == '/') && (o2 == '+' || o2 == '-')) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    private double calulate(char o, double b, double a) {
//        switch (o) {
//            case '+':
//                return a + b;
//            case '-':
//                return a - b;
//            case '*':
//                return a * b;
//            case '/':
//                if (b == 0) {
//                    throw new ArithmeticException("Cannot divide by zero");
//                }
//                return a / b;
//        }
//        return 0;
//    }
}