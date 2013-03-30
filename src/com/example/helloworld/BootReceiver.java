package com.example.helloworld;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(final Context context, Intent intent) {
    if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          Intent intent = new Intent(context, MainService.class);
          context.startService(intent);
        }
      }).start();
    }
  }
}
