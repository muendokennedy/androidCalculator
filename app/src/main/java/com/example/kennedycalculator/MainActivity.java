package com.example.kennedycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);

        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(getString(R.string.display).equals(display.getText().toString())){
                   display.setText("");
               }
            }
        });
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);

        } else {
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));

            display.setSelection(cursorPos + 1);
        }


    }

    public void zeroBtn(View view){
        updateText("0");
    }

    public void oneBtn(View view){
        updateText("1");
    }

    public void twoBtn(View view){
        updateText("2");
    }

    public void threeBtn(View view){
        updateText("3");
    }

    public void fourBtn(View view){
        updateText("4");
    }

    public void fiveBtn(View view){
        updateText("5");
    }

    public void sixBtn(View view){
        updateText("6");
    }

    public void sevenBtn(View view){
        updateText("7");
    }

    public void eightBtn(View view){
        updateText("8");
    }

    public void nineBtn(View view){
        updateText("9");
    }

    public void addBtn(View view){
        updateText("+");
    }

    public void subtractBtn(View view){
        updateText("-");
    }

    public void multiplyBtn(View view){
        updateText("×");
    }

    public void divideBtn(View view){
        updateText("÷");
    }

    public void clearBtn(View view){
        display.setText("");
    }

    public void exponentBtn(View view){
        updateText("^");
    }

    public void plusMinusBtn(View view){
        updateText("+/-");
    }

    public void equalsBtn(View view){
        updateText("");
    }

    public void parenthesisBtn(View view){
        int cursPos = display.getSelectionStart();
        int openParenthesis = 0;
        int closeParenthesis = 0;
        int textLength = display.getText().length();

        for (int i = 0; i < cursPos; i++) {
            if(display.getText().toString().substring(i, i+1).equals("(")){
                openParenthesis += 1;
            }
            if(display.getText().toString().substring(i, i+1).equals(")")){
                closeParenthesis += 1;
            }
        }

        if(openParenthesis == closeParenthesis || display.getText().toString().substring(textLength-1, textLength).equals("(")){
            updateText("(");
        }

        else if(closeParenthesis < openParenthesis && !display.getText().toString().substring(textLength-1, textLength).equals("c")){
            updateText(")");
        }
        display.setSelection(cursPos + 1);
    }

    public void backspaceBtn(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if(cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();

            selection.replace(cursorPos - 1, cursorPos, "");

            display.setText(selection);

            display.setSelection(cursorPos - 1);
        }
    }

    public void pointBtn(View view){
        updateText(".");
    }
}