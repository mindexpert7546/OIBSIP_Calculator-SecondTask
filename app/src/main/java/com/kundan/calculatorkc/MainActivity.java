package com.kundan.calculatorkc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.calculatorkc.R;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {
    ImageView btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_0;
    ImageView btn_dot,btn_equal,btn_multi,btn_module,btn_add,btn_sub,btn_ac,btn_div;

    TextView textInput,textOutput;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);

        btn_dot = findViewById(R.id.btn_dot);
        btn_equal = findViewById(R.id.btn_equal);
        btn_multi = findViewById(R.id.btn_multiply);
        btn_module = findViewById(R.id.btn_module);
        btn_add = findViewById(R.id.btn_plus);
        btn_sub = findViewById(R.id.btn_minus);
        btn_ac = findViewById(R.id.btn_ac);
        btn_div = findViewById(R.id.btn_div);

        textInput = findViewById(R.id.inputText);
        textOutput = findViewById(R.id.inputOutput);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "0");
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "1");
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "2");
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "3");
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "4");
            }
        });

        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "5");
            }
        });

        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "6");
            }
        });

        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "7");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "8");
            }
        });

        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "9");
            }
        });


        btn_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textInput.setText("");
                textOutput.setText("");
            }
        });

        btn_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + ".");
            }
        });

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "+");
            }
        });

        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "-");
            }
        });


        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "×");
            }
        });

        btn_module.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "%");
            }
        });

        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();
                textInput.setText(data + "÷");
            }
        });

        btn_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = textInput.getText().toString();

                data=data.replaceAll("×","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");

                //https://github.com/F43nd1r/rhino-android
                //use for output
                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalRes = "";

                Scriptable scriptable = rhino.initStandardObjects();
                finalRes=rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();

                textOutput.setText(finalRes);

                //Toast.makeText(MainActivity.this, " " + data, Toast.LENGTH_LONG).show();
            }
        });

    }
}