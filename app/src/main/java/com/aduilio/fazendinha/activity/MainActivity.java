package com.aduilio.fazendinha.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.aduilio.fazendinha.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ImageView porco = (ImageView) findViewById(R.id.iv_main_porco);
        porco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ImageView carneiro = (ImageView) findViewById(R.id.iv_main_carneiro);
        carneiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void onVacaClick(View view) {
    }

    public void onPeruClick(View view) {
    }
}
