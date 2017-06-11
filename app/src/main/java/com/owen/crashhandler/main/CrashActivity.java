package com.owen.crashhandler.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.owen.crashhandler.R;

public class CrashActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crash);
    }

    @Override
    protected void onResume() {
        super.onResume();
        textView.setText("owen");
    }
}
