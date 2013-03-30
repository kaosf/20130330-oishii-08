package com.example.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

public class MainService extends Service {

  private Thread thread = null;

  private Handler handler = new Handler();

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    this.thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (true) {
          try {
            MainService.this.handler.post(new Runnable() {
              @Override
              public void run() {
                Toast.makeText(MainService.this, "loop", Toast.LENGTH_LONG).show();
              }
            });
            Thread.sleep(10 * 1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    });
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
  }

}
