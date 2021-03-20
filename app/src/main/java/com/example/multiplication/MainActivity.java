package com.example.multiplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView text;
    EditText number;
    Button button;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        number = findViewById(R.id.Number1);
        button = findViewById(R.id.button);
        clear = findViewById(R.id.clear);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText(" ");
                number.setText(null);
            }
        });
        number.setText("0");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Toast.makeText(MainActivity.this, "Thanks For Using!", Toast.LENGTH_SHORT).show();
              text.append("\nShowing result for " + Integer.parseInt(number.getText().toString()));
              text.append("\n"+"******************************************");
              int n = Integer.parseInt(number.getText().toString());
              int sum;
              int i = 0;
              do {
                  sum = n * i;
                  text.append("\n" + n + " X " + i + " = " + sum);
                  i++;
              } while (i <= 10);
                text.append("\n"+"******************************************");
                text.setMovementMethod(new ScrollingMovementMethod());
            }
        });
        number.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (number.length() > 0){
                    button.setEnabled(true);
                } else {
                    button.setEnabled(false);
                }
            }
        });
    }
}