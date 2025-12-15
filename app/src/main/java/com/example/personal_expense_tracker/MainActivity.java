package com.example.personal_expense_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout btnGeneral = findViewById(R.id.btnGeneral);
        LinearLayout btnScience = findViewById(R.id.btnScience);

        btnGeneral.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, GeneralKnowledgeActivity.class))
        );

        btnScience.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ScienceActivity.class))
        );
    }
}
