package com.aduilio.fazendinha.activity;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.aduilio.fazendinha.R;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer player;
    private Vibrator vibrator;

    private boolean vibrate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setVolumeControlStream(AudioManager.STREAM_MUSIC);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        ImageView porco = (ImageView) findViewById(R.id.iv_main_porco);
        porco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(R.raw.porco);
            }
        });

        ImageView pato = (ImageView) findViewById(R.id.iv_main_pato);
        pato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSound(R.raw.pato);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        vibrate = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("vibrate", true);
    }

    @Override
    protected void onPause() {
        if (player != null && player.isPlaying()) {
            player.stop();
            player.release();
        }

        if (vibrator != null) {
            vibrator.cancel();
        }

        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, SettingsActivity.class));
                break;
        }

        return true;
    }

    public void onVacaClick(View view) {
        playSound(R.raw.vaca);
    }

    public void onPeruClick(View view) {
        playSound(R.raw.peru);
    }

    private void playSound(int sound) {
        player = MediaPlayer.create(this, sound);
        player.start();

        if (vibrate) {
            long[] pattern = {50, 100, 50, 100};
            vibrator.vibrate(pattern, -1);
        }
    }
}
