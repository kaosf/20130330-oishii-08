package com.example.helloworld;

import android.os.Bundle;
import android.util.Log;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "START", Toast.LENGTH_LONG).show();
                Log.d("Tam", "Yokoyama");
                Intent intent = new Intent(MainActivity.this, MainService.class);
                startService(intent);
            }
        });

        Button stopbutton = (Button) findViewById(R.id.button2);
        stopbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "STOP", Toast.LENGTH_LONG).show();
                Log.d("TamTam", "Yokoyama 2nd");
                Intent intent = new Intent(MainActivity.this, MainService.class);
                stopService(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
