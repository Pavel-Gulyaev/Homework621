package com.example.homework6_2_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int ActivityNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button leftButton = (Button) findViewById(R.id.leftButton);
        Button rightButton = (Button) findViewById(R.id.rightButton);
        TextView textView = (TextView) findViewById(R.id.textView);

        Random random = new Random();
        if(ActivityNumber == 0){
            ActivityNumber = random.nextInt(100);
        }

        textView.setText("Изображение № " + ActivityNumber);

        leftButton.setOnClickListener(this);
        rightButton.setOnClickListener(this);
        logActivity("onCreate");
    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.rightButton: {
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                break;
            }
            case R.id.leftButton:{
                this.finish();
                break;
            }
        }
    }

    private void logActivity(String methodName){
        Log.d("Lifecycle", ActivityNumber+methodName);
    }

    @Override
    protected void onStart() {

        super.onStart();
        logActivity("onStart");
    }

    @Override
    protected void onResume() {

        super.onResume();
        logActivity("onResume");
    }

    @Override
    protected void onPause() {

        super.onPause();
        logActivity("onPause");
    }

    @Override
    protected void onStop() {

        super.onStop();
        logActivity("onStop");
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
        logActivity("onDestroy");
    }

    @Override
    protected void onRestart() {

        super.onRestart();
        logActivity("onRestart");
    }
}
