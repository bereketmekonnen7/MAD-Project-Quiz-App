package com.example.personal_expense_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LinearLayout btnGeneral = findViewById(R.id.btnGeneral);
        LinearLayout btnScience = findViewById(R.id.btnScience);
        Button btnHome = findViewById(R.id.btnHome);
        Button btnQuiz = findViewById(R.id.btnQuiz);
        Button btnHistory = findViewById(R.id.btnHistory);


        btnGeneral.setOnClickListener(v ->
                startActivity(new Intent(QuizHomeActivity.this, GeneralKnowledgeActivity.class))
        );

        btnScience.setOnClickListener(v ->
                startActivity(new Intent(QuizHomeActivity.this, ScienceActivity.class))
        );

        // 1. Home Button -> Go to MainActivity
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(QuizHomeActivity.this, MainActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });

        // 2. Quiz Button -> Stay here
        btnQuiz.setOnClickListener(v -> {
            Toast.makeText(QuizHomeActivity.this, "You are already in the Quiz section", Toast.LENGTH_SHORT).show();
        });

        // 3. History Button -> Go to HistoryActivity
        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(QuizHomeActivity.this, HistoryActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });


    }
}