package com.example.sumansoft.ssp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class KuldeepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuldeep);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_kuldeep);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        toolbar.setTitle("Our Leadership");
        toolbar.setTitleTextColor(Color.WHITE);



        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KuldeepActivity.this,MainActivity.class));
            }
        });
    }
}
