package com.example.componentsgallery;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button openExpandableRecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openExpandableRecyclerview = findViewById(R.id.btn_exp);
        openExpandableRecyclerview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.openActivity(MainActivity.this, com.example.componentsgallery.components.expandable_recyclerview.MainActivity.class, new String[]{}, new String[]{});
            }
        });
    }
}
