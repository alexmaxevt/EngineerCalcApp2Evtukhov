package ru.evtukhov.android.engineercalcapp2;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView screen;

    private Float num1;
    private Float num2;
    private Float result;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = findViewById(R.id.calc);
        view.setVisibility(View.INVISIBLE);
        initView();
    }

    private void initView() {
        screen = findViewById(R.id.screen);
        TextView buttonC = findViewById(R.id.clear);
        TextView buttonPlusOrMinus = findViewById(R.id.plusOrMinus);
        TextView buttonPercent = findViewById(R.id.percent);
        TextView buttonDivision = findViewById(R.id.division);
        TextView buttonSeven = findViewById(R.id.seven);
        TextView buttonEight = findViewById(R.id.eight);
        TextView buttonNine = findViewById(R.id.nine);
        TextView buttonMultiplication = findViewById(R.id.multiplication);
        TextView buttonFour = findViewById(R.id.four);
        TextView buttonFive = findViewById(R.id.five);
        TextView buttonSix = findViewById(R.id.six);
        TextView buttonSubtraction = findViewById(R.id.subtraction);
        TextView buttonOne = findViewById(R.id.one);
        TextView buttonTwo = findViewById(R.id.two);
        TextView buttonThree = findViewById(R.id.three);
        TextView buttonAddition = findViewById(R.id.addition);
        TextView buttonZero = findViewById(R.id.zero);
        TextView buttonDot = findViewById(R.id.dot);
        TextView buttonEqually = findViewById(R.id.equally);
        final View view = findViewById(R.id.calc);
        final View view2 = findViewById(R.id.engineer);
        ImageButton ordinary = findViewById(R.id.ordinaryView);
        ImageButton engineer = findViewById(R.id.engineerView);

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("");
                num1 = 0F;
                num2 = 0F;
            }
        });

        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notDoubleNull = screen.getText().toString();
                if (notDoubleNull.contains(getString(R.string.app_dot))) {
                    screen.append(getString(R.string.app_zero));
                }
                else {
                    if (notDoubleNull.startsWith(getString(R.string.app_zero))) {
                        screen.append(getString(R.string.app_dot));
                    }
                    else {
                        screen.append(getString(R.string.app_zero));
                    }
                }
            }
        });

        buttonOne.setOnClickListener(getCalcButtonClickListener(R.string.app_one));
        buttonTwo.setOnClickListener(getCalcButtonClickListener(R.string.app_two));
        buttonThree.setOnClickListener(getCalcButtonClickListener(R.string.app_three));
        buttonFour.setOnClickListener(getCalcButtonClickListener(R.string.app_four));
        buttonFive.setOnClickListener(getCalcButtonClickListener(R.string.app_five));
        buttonSix.setOnClickListener(getCalcButtonClickListener(R.string.app_six));
        buttonSeven.setOnClickListener(getCalcButtonClickListener(R.string.app_seven));
        buttonEight.setOnClickListener(getCalcButtonClickListener(R.string.app_eight));
        buttonNine.setOnClickListener(getCalcButtonClickListener(R.string.app_nine));

        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notDoubleDot = screen.getText().toString();
                if (notDoubleDot.contains(getString(R.string.app_dot))) {
                    v.setClickable(false);
                }
                else {
                    screen.append(getString(R.string.app_dot));
                }
            }
        });

        buttonPlusOrMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String plusOrMinus = screen.getText().toString();
                String minus = getString(R.string.app_subtraction) + plusOrMinus;
                String plus = getString(R.string.app_addition) + plusOrMinus;
                if (Float.valueOf(screen.getText().toString()) > 0) {
                    screen.setText(minus);
                }
                else {
                    screen.setText(plus.substring(1));
                }
            }
        });

        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Float.valueOf(screen.getText().toString())/100;
                screen.setText(num1.toString());
            }
        });

        buttonAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "+";
                num1 = Float.valueOf(screen.getText().toString());
                screen.setText("");
            }
        });

        buttonSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "-";
                num1 = Float.valueOf(screen.getText().toString());
                screen.setText("");
            }
        });

        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "×";
                num1 = Float.valueOf(screen.getText().toString());
                screen.setText("");
            }
        });

        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operator = "÷";
                num1 = Float.valueOf(screen.getText().toString());
                screen.setText("");
            }
        });

        buttonEqually.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operator != null) {
                    num2 = Float.valueOf(screen.getText().toString());
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            screen.setText(result.toString());
                            break;
                        case "-":
                            result = num1 - num2;
                            screen.setText(result.toString());
                            break;
                        case "×":
                            result = num1 * num2;
                            screen.setText(result.toString());
                            break;
                        case "÷":
                            if (num2 != 0F) {
                                result = num1 / num2;
                                screen.setText(result.toString());
                            }
                            else {
                                screen.setText(getString(R.string.app_error));
                            }
                            break;
                    }
                    num1 = result;
                }
                else {
                    num1 = Float.valueOf(screen.getText().toString());
                    screen.setText(num1.toString());
                }
            }
        });

        ordinary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setVisibility(View.VISIBLE);
                view2.setVisibility(View.INVISIBLE);
            }
        });

        engineer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                view.setVisibility(View.INVISIBLE);
                view2.setVisibility(View.VISIBLE);
            }
        });
    }

    private View.OnClickListener getCalcButtonClickListener(@StringRes final int numberResource) {
        final String number = getString(numberResource);

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.append(number);
            }
        };
    }
}
