package com.example.peter.hackpack_android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        Button toCameraActivity = (Button) this.findViewById(R.id.to_camera);
        toCameraActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent nextPageIntent = new Intent(WelcomeScreen.this, CameraActivity.class);
                startActivity(nextPageIntent);
            }
        });
    }
}
