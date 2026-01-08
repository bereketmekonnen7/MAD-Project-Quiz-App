package com.example.personal_expense_tracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GeneralKnowledgeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_general_knowledge);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Initialize Views
        // btnStartScience is a Button in XML
        Button btnStart = findViewById(R.id.btnStartGenKnow);


        Button btnHome = findViewById(R.id.navHome);
        Button btnQuiz = findViewById(R.id.navQuiz);
        Button btnHistory = findViewById(R.id.navHistory);
        //EventListener
        btnStart.setOnClickListener(v -> {
            Intent intent = new Intent(this, QuizActivity.class);
            intent.putExtra("QUIZ_TYPE", "GK");
            startActivity(intent);
        });


        // --- Bottom Navigation Bar---

        // 1. Home Button -> Go to MainActivity
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(GeneralKnowledgeActivity.this, MainActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });

        // 2. Quiz Button -> Stay here
        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(GeneralKnowledgeActivity.this, MainActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });

        // 3. History Button -> Go to HistoryActivity
        btnHistory.setOnClickListener(v -> {

            Toast.makeText(GeneralKnowledgeActivity.this, "History Feature Coming Soon", Toast.LENGTH_SHORT).show();
        });
    }
}