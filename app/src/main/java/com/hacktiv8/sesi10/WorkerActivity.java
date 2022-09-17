package com.hacktiv8.sesi10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.TimeUnit;

public class WorkerActivity extends AppCompatActivity implements View.OnClickListener {

    Button runWorkerButton;
    WorkRequest workRequest;
    WorkManager workManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker);

        runWorkerButton = (Button) findViewById(R.id.runWorker);
        runWorkerButton.setOnClickListener(this);

        workManager = WorkManager.getInstance(getApplicationContext());
        workRequest = new PeriodicWorkRequest.Builder(MyWorker.class, 3, TimeUnit.MINUTES).build();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.runWorker){
            workManager.enqueue(workRequest);
        }
    }
}