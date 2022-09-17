package com.hacktiv8.sesi10;

import android.content.Context;
import android.util.Log;

import java.util.Random;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class MyWorker extends Worker {

    private static String TAG = MyWorker.class.getName();
    private int randomNumber;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {

        while (!isStopped()){
            try {
                Thread.sleep(1000);

                randomNumber = new Random().nextInt();

                Log.i(TAG, "Thread id "+Thread.currentThread().getId()+" Random Number:"+randomNumber);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return Result.success();
    }
}
