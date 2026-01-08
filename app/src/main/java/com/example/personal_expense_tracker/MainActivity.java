package com.example.personal_expense_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SessionManager session = new SessionManager(this);

        if (session.getUserId() == -1) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        TextView txtUsername = findViewById(R.id.txtUsername);
        txtUsername.setText("Hi, " + session.getUsername());

        LinearLayout btnGeneral = findViewById(R.id.btnGeneral);
        LinearLayout btnScience = findViewById(R.id.btnScience);
        Button btnHome = findViewById(R.id.btnHome);
        Button btnQuiz = findViewById(R.id.btnQuiz);
        Button btnHistory = findViewById(R.id.btnHistory);


        btnGeneral.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, GeneralKnowledgeActivity.class))
        );

        btnScience.setOnClickListener(v ->
                startActivity(new Intent(MainActivity.this, ScienceActivity.class))
        );

        // 1. Home Button -> Go to MainActivity
        btnHome.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "You are already in the Home section", Toast.LENGTH_SHORT).show();
        });

        // 2. Quiz Button -> Go to QuizActivity
        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizHomeActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });

        // 3. History Button -> Go to HistoryActivity
        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });


    }
}
