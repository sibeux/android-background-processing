package com.hacktiv8.sesi10;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

public class ProgressTask extends AsyncTask<Void, Integer, String> {

    ProgressDialog dialog;
    Context context;

    public ProgressTask(Context context){
        this.context = context;
    }
    @Override
    protected String doInBackground(Void... voids) {
        for(int i=0; i<=10; i++ ){
            try {
                Thread.sleep(1000);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Selesai";
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(context);
        dialog.setTitle("Downloading");
        dialog.setMessage("Please Wait...");
        dialog.setMax(10);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        dialog.dismiss();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];
        dialog.setProgress(value);
    }


}
