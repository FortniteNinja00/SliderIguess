package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView cytat;
    TextView header;
    TextView rozmiar;
    SeekBar seekBar;
    int pomocnicza = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        cytat = findViewById(R.id.cytat);
        header = findViewById(R.id.header);
        rozmiar = findViewById(R.id.rozmiar);
        seekBar = findViewById(R.id.seekBar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seekBar.setMin(0);
        }
        seekBar.setMax(40);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int seekbarvalue = (int)seekBar.getProgress();

                String rozmiarchanged = "Rozmiar: " +seekbarvalue;
                rozmiar.setText(rozmiarchanged);

                cytat.setTextSize(1,seekbarvalue);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pomocnicza++;

                String[] cytaty = {"Dzień dobry", "Good morning", "Buenos Dias"};
                if (pomocnicza >= cytaty.length) {
                    pomocnicza = 0;
                }
                cytat.setText(cytaty[pomocnicza]);
            }
        });
    }
}