package com.example.helloworld;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;
import android.app.Notification;
import android.app.NotificationManager;

public class MainService extends Service {

  private Thread thread = null;

  private Handler handler = new Handler();

  private boolean loop = true;

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    // NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    // Notification tuuchi = new Notification(R.drawable.ic_launcher, "Hyahho-", System.currentTimeMillis());
    // nm.notify(1, tuuchi);
    //// Icon is needed.

    this.thread = new Thread(new Runnable() {
      @Override
      public void run() {
        while (loop) {
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
            return;
          }
        }
      }
    });
    this.thread.start();
  }

  @Override
  public void onDestroy() {
    this.loop = false;
    this.thread.interrupt();
    super.onDestroy();
  }

  // void start() {
  //   this.thread.start();
  // }

  // void stop() {
  //   this.loop = false;
  // }
}
