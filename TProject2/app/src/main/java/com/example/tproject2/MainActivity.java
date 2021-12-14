package com.example.tproject2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button bW;
    Button bR;
    String str = "";

    final String FINAL_NAME ="file.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tV1);
        editText = findViewById(R.id.eT1);
        bW = findViewById(R.id.b1);
        bR = findViewById(R.id.b2);

        bR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText("");
                try {
                    BufferedReader br = new BufferedReader(new
                            InputStreamReader(openFileInput (FINAL_NAME)));
                    while (true) {

                        str = br.readLine();
                        if (str == null) break;
                        textView.append(str);
                    }
                    br.close();

                }
                 catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        bW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    BufferedWriter bw = new BufferedWriter(new
                            OutputStreamWriter(openFileOutput (FINAL_NAME,
                            MODE_PRIVATE)));
                    bw.write(editText.getText().toString());
                    bw.close();
                }  catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}