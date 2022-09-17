package com.hacktiv8.sesi10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button downloadButton;
    TextView textView;
    private static String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadButton = (Button) findViewById(R.id.downloadButton);
        downloadButton.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.status);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.downloadButton){
            //runThread();

            //Intent Service
//            Intent intent = new Intent(MainActivity.this, BackgroundService.class);
//            intent.putExtra("sleep", 10);
//            startService(intent);


            //AsyncTask
            ProgressTask task = new ProgressTask(this);
            task.execute();


        }
    }

    private void runThread(){
        textView.setText("Download Start...");

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

                Log.i(TAG, "Download Start...");
                synchronized (this){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Log.i(TAG, "Download Selesai");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("Download Finish...");
                    }
                });

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}