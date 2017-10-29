package com.stopwatch.tejas.stopwatch;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    private Button start, stop, reset, lap = null;
    private TextView lap1, lap2, lap3;
    private Chronometer chrono = null;
    private long timeStopped = 0;
    private AdView adView;
    private Animation anim;
    private RelativeLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        adView = (AdView) findViewById(R.id.adView);

        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        reset = (Button) findViewById(R.id.reset);
        chrono = (Chronometer) findViewById(R.id.chrono);
        layout = (RelativeLayout) findViewById(R.id.activity_main);
        lap = (Button) findViewById(R.id.lap);
        lap1 = (TextView) findViewById(R.id.lap1);
        lap2 = (TextView) findViewById(R.id.lap2);
        lap3 = (TextView) findViewById(R.id.lap3);

        anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(250); //Change duration of the blink
        anim.setStartOffset(20);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatCount(3); //Change repetitions of animation


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_dark:
                item.setChecked(true);
                layout.setBackgroundColor(Color.argb(255,2,25,56));
                chrono.setTextColor(Color.argb(255,211,229,240));
                start.setTextColor(Color.argb(255,211,229,240));
                stop.setTextColor(Color.argb(255,211,229,240));
                reset.setTextColor(Color.argb(255,211,229,240));
                lap1.setTextColor(Color.argb(255,211,229,240));
                lap2.setTextColor(Color.argb(255,211,229,240));
                lap3.setTextColor(Color.argb(255,211,229,240));
                lap.setTextColor(Color.argb(255,211,229,240));
                return true;

            case R.id.menu_light:
                item.setChecked(true);
                layout.setBackgroundColor(Color.argb(255,211,229,240));
                chrono.setTextColor(Color.argb(255,2,25,56));
                start.setTextColor(Color.argb(255,2,25,56));
                stop.setTextColor(Color.argb(255,2,25,56));
                reset.setTextColor(Color.argb(255,2,25,56));
                lap1.setTextColor(Color.argb(255,2,25,56));
                lap2.setTextColor(Color.argb(255,2,25,56));
                lap3.setTextColor(Color.argb(255,2,25,56));
                lap.setTextColor(Color.argb(255,2,25,56));
                return true;

            case R.id.menu_red:
                item.setChecked(true);
                layout.setBackgroundColor(Color.argb(255,233,19,19));
                chrono.setTextColor(Color.argb(255,255,255,255));
                start.setTextColor(Color.argb(255,255,255,255));
                stop.setTextColor(Color.argb(255,255,255,255));
                reset.setTextColor(Color.argb(255,255,255,255));
                lap1.setTextColor(Color.argb(255,211,229,240));
                lap2.setTextColor(Color.argb(255,211,229,240));
                lap3.setTextColor(Color.argb(255,211,229,240));
                lap.setTextColor(Color.argb(255,211,229,240));
                return true;

            case R.id.menu_green:
                item.setChecked(true);
                layout.setBackgroundColor(Color.argb(255,74,229,13));
                chrono.setTextColor(Color.argb(255,255,255,255));
                start.setTextColor(Color.argb(255,255,255,255));
                stop.setTextColor(Color.argb(255,255,255,255));
                reset.setTextColor(Color.argb(255,255,255,255));
                lap1.setTextColor(Color.argb(255,211,229,240));
                lap2.setTextColor(Color.argb(255,211,229,240));
                lap3.setTextColor(Color.argb(255,211,229,240));
                lap.setTextColor(Color.argb(255,211,229,240));
                return true;

            case R.id.menu_blue:
                item.setChecked(true);
                layout.setBackgroundColor(Color.argb(255,28,94,228));
                chrono.setTextColor(Color.argb(255,255,255,255));
                start.setTextColor(Color.argb(255,255,255,255));
                stop.setTextColor(Color.argb(255,255,255,255));
                reset.setTextColor(Color.argb(255,255,255,255));
                lap1.setTextColor(Color.argb(255,211,229,240));
                lap2.setTextColor(Color.argb(255,211,229,240));
                lap3.setTextColor(Color.argb(255,211,229,240));
                lap.setTextColor(Color.argb(255,211,229,240));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void startTimer(View v) {
        chrono.setBase(SystemClock.elapsedRealtime() + timeStopped);
        chrono.start();
        start.setEnabled(false);
        stop.setEnabled(true);
        lap.setEnabled(true);
    }

    public void stopTimer(View v) {
        timeStopped = chrono.getBase() - SystemClock.elapsedRealtime();
        chrono.stop();
        start.setEnabled(true);
        chrono.startAnimation(anim);
        lap.setEnabled(false);
    }

    public void resetTimer(View v) {
        chrono.setBase(SystemClock.elapsedRealtime());
        timeStopped = 0;
        chrono.stop();
        start.setEnabled(true);
        stop.setEnabled(false);
        lap.setEnabled(false);

        lap1.setText("Lap 1:    ");
        lap2.setText("Lap 2:    ");
        lap3.setText("Lap 3:    ");
    }

    public void lapTimer(View v) {
        if (chrono.getText().equals("00:00")) {
            return;
        }
        if (lap1.getText().toString().endsWith(" ")) {
            lap1.append(chrono.getText());
            return;
        }
        if (lap2.getText().toString().endsWith(" ")) {
            lap2.append(chrono.getText());
            return;
        }
        if (lap3.getText().toString().endsWith(" ")) {
            lap3.append(chrono.getText());
            return;
        }



    }

}

