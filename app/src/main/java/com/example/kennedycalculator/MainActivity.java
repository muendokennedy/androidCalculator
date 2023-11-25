package com.example.kennedycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
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
        updateText("0");
    }

    public void subtractBtn(View view){
        updateText("+");
    }

    public void multiplyBtn(View view){
        updateText("×");
    }

    public void divideBtn(View view){
        updateText("÷");
    }

    public void clearBtn(View view){
        updateText("");
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
        updateText("");
    }

    public void backspaceBtn(View view){
        updateText("");
    }

    public void pointBtn(View view){
        updateText(".");
    }
}