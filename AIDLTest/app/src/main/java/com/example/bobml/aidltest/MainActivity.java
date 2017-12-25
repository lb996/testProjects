package com.example.bobml.aidltest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("tag", "onCreate: this is first");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag", "onStart: this is second");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag", "onRestart: this is third");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag", "onResume: this is fourth");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag", "onPause: this is fifth");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag", "onStop: this is sixth");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag", "onDestroy: this is seventh");
    }
}
