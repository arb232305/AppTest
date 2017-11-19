package com.example.avery.apptest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;

import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int coll = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.aldens_button);
        final TextView text = findViewById(R.id.averys_text);
        final String[] collors = {"#0015ff", "#ff2600", "#00ff19", "#000000", "#d002ff"};

        final RelativeLayout layout = findViewById(R.id.layout);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                text.setText("bum");
                text.setTextColor(Color.parseColor(collors[coll]));

                if (coll == collors.length - 1) {
                    coll = 0;
                } else {
                    coll++;
                }

                addText(layout, "BLAH!");

            }
        });
    }

    public void addText(RelativeLayout layout, String text){
        TextView newText = new TextView(this);
        newText.setText(text);
        newText.setId((int)(Math.random() * 1000));
        newText.setWidth(1000);
        newText.setHeight(200);
        newText.setX((int)(Math.random() * 1000));
        newText.setY((int)(Math.random() * 1000));

        layout.addView(newText);
    }
}

