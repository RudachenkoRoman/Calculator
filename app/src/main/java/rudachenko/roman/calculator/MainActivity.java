package rudachenko.roman.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPoint, bPi, bResult, bSum, bSubtraction, bMultiplication;
    Button bDivision, bRoot, bSquare, bFactorial, bSin, bCos, bTan, bLog, bAC, bC, bBracketLeft, bBracketRight;
    TextView tvMain ,tvSec;

    private final String ERROR = "Input error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMain = findViewById(R.id.tv_main);
        tvSec = findViewById(R.id.tv_sec);

        b0 = findViewById(R.id.bottom_0);
        b1 = findViewById(R.id.bottom_1);
        b2 = findViewById(R.id.bottom_2);
        b3 = findViewById(R.id.bottom_3);
        b4 = findViewById(R.id.bottom_4);
        b5 = findViewById(R.id.bottom_5);
        b6 = findViewById(R.id.bottom_6);
        b7 = findViewById(R.id.bottom_7);
        b8 = findViewById(R.id.bottom_8);
        b9 = findViewById(R.id.bottom_9);
        bPoint = findViewById(R.id.bottom_point);
        bPi = findViewById(R.id.bottom_Pi);
        bResult = findViewById(R.id.bottom_result);
        bSum = findViewById(R.id.bottom_sum);
        bSubtraction = findViewById(R.id.bottom_subtraction);
        bMultiplication = findViewById(R.id.bottom_multiplication);
        bDivision = findViewById(R.id.bottom_division);
        bRoot = findViewById(R.id.bottom_root);
        bSquare = findViewById(R.id.bottom_square);
        bFactorial = findViewById(R.id.bottom_factorial);
        bSin = findViewById(R.id.bottom_sin);
        bCos = findViewById(R.id.bottom_cos);
        bTan = findViewById(R.id.bottom_tan);
        bLog = findViewById(R.id.bottom_log);
        bAC = findViewById(R.id.bottom_AC);
        bC = findViewById(R.id.bottom_C);
        bBracketLeft = findViewById(R.id.bottom_bracket_left);
        bBracketRight = findViewById(R.id.bottom_bracket_right);

        tvMain.setText("0");

        b0.setOnClickListener(v -> {
            if (!tvMain.getText().toString().equals("0")) {
                tvMain.setText(String.format("%s%s", tvMain.getText(), "0"));
            }
        });

        b1.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "1"));
        });

        b2.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "2"));
        });

        b3.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "3"));
        });

        b4.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "4"));
        });

        b5.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "5"));
        });

        b6.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "6"));
        });

        b7.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "7"));
        });

        b8.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "8"));
        });

        b9.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "9"));
        });

        bPoint.setOnClickListener(v -> {
            if (!tvMain.getText().toString().isEmpty()) {
                tvMain.setText(String.format("%s%s", tvMain.getText(), "."));
            }

            if (tvMain.getText().toString().equals("0")) {
                tvMain.setText(String.format("%s%s", tvMain.getText(), "."));
            }

        });

        bPi.setOnClickListener(v -> {
            setZero();
            String val = String.valueOf(Math.PI).substring(0,4);
            tvMain.setText(String.format("%s%s", tvMain.getText(), val));
        });

        bResult.setOnClickListener(v -> {
            try {
                String val = tvMain.getText().toString();
                String replace = val.replace("×", "*");
                double res = eval(replace);
                String s = String.valueOf(res);
                String s1 = s.substring(s.length() - 2);
                if (s1.contains(".0")){
                    int result = (int) res;
                    tvMain.setText(String.valueOf(result));
                    tvSec.setText(val);
                } else {
                    tvMain.setText(String.valueOf(res));
                    tvSec.setText(val);
                }
            } catch (RuntimeException e){
                tvMain.setText(ERROR);
            }

        });
        bSum.setOnClickListener(v -> tvMain.setText(String.format("%s%s", tvMain.getText(), "+")));

        bSubtraction.setOnClickListener(v -> tvMain.setText(String.format("%s%s", tvMain.getText(), "-")));

        bMultiplication.setOnClickListener(v -> tvMain.setText(String.format("%s%s", tvMain.getText(), "×")));

        bDivision.setOnClickListener(v -> tvMain.setText(String.format("%s%s", tvMain.getText(), "/")));

        bRoot.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "sqrt "));
        });

        bSquare.setOnClickListener(v -> {
            double val = Double.parseDouble(tvMain.getText().toString());
            double res = pow(val);
            String s = String.valueOf(res);
            String s1 = s.substring(s.length() - 2);
            if (s1.contains(".0")){
                int result = (int) res;
                int input = (int) val;
                tvMain.setText(String.valueOf(result));
                tvSec.setText(String.format(input + "²"));
            } else {
                tvMain.setText(String.valueOf(res));
                tvSec.setText(String.format(val + "²"));
            }
        });

        bFactorial.setOnClickListener(v -> {
            double val = Double.parseDouble(tvMain.getText().toString());
            int integer = (int) Math.floor(val);
            int factorial = integerFactorial(integer);
            tvMain.setText(String.valueOf(factorial));
            tvSec.setText(String.format("%s!", integer));
        });
        bSin.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "sin "));
        });

        bCos.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "cos "));
        });

        bTan.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "tan "));
        });

        bLog.setOnClickListener(v -> {
            setZero();
            tvMain.setText(String.format("%s%s", tvMain.getText(), "log "));
        });

        bAC.setOnClickListener(v -> {
            tvMain.setText("0");
            tvSec.setText("");
        });

        bC.setOnClickListener(v -> {
            String res = tvMain.getText().toString();
            if (!(res.length() == 1)) {
                res = res.substring(0, res.length() - 1);
                tvMain.setText(res);
            } else {
                tvMain.setText("0");
            }
        });

        bBracketLeft.setOnClickListener(v -> tvMain.setText(String.format("%s%s", tvMain.getText(), "(")));

        bBracketRight.setOnClickListener(v -> tvMain.setText(String.format("%s%s", tvMain.getText(), ")")));
    }
    private int integerFactorial (int i){
        return (i == 1 || i == 0) ? 1 : i * integerFactorial(i - 1);
    }

    private void setZero (){
        if (tvMain.getText().toString().equals("0")){
            tvMain.setText("");
        }
    }

    private double pow (double i){
        return (i * i);
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else if (func.equals("log")) x = Math.log10(x);
                    else if (func.equals("ln")) x = Math.log(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}