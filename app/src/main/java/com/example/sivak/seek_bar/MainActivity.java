package com.example.sivak.seek_bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static SeekBar seekBar;
    private static TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.textView);
        textView.setText("Covered : " + seekBar.getProgress() + " / " + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value = progress;
                textView.setText("covered : " + progress + " / " + seekBar.getMax());
                Toast.makeText(MainActivity.this, "Seekbar in progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Seekbar in start tracking", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("covered : " + progress_value + " / " + seekBar.getMax());
                Toast.makeText(MainActivity.this, "Seekbar in stop tracking", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
