package com.example.personal_expense_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    TextView txtTitle, txtScore;
    Button btnRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtTitle = findViewById(R.id.txtQuizTitle);
        txtScore = findViewById(R.id.txtScore);
        btnRetry = findViewById(R.id.btnRetry);
        Button btnHome = findViewById(R.id.btnHome);
        Button btnQuiz = findViewById(R.id.btnQuiz);
        Button btnHistory = findViewById(R.id.btnHistory);


        String quizType = getIntent().getStringExtra("QUIZ_TYPE");
        int score = getIntent().getIntExtra("SCORE", 0);
        int total = getIntent().getIntExtra("TOTAL", 0);

        txtTitle.setText(
                quizType.equals("SCIENCE")
                        ? "Science Quiz"
                        : "General Knowledge Quiz"
        );

        txtScore.setText("You Got: " + score + "/" + total);

        btnRetry.setOnClickListener(v -> {
            Intent i = new Intent(this, QuizActivity.class);
            i.putExtra("QUIZ_TYPE", quizType);
            startActivity(i);
            finish();
        });

        // 1. Home Button -> Go to MainActivity
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });

        // 2. Quiz Button -> Go to QuizActivity
        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, QuizHomeActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });

        // 3. History Button -> Go to HistoryActivity
        btnHistory.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, HistoryActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });
    }
}

