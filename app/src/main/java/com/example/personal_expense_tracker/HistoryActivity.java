package com.example.personal_expense_tracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    DatabaseHelper db;
    SessionManager session;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_history);

        session = new SessionManager(this);

        if (session.getUserId() == -1) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        db = new DatabaseHelper(this);
        container = findViewById(R.id.container);

        int userId = session.getUserId();

        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.rawQuery(
                "SELECT quiz_type, score, total, date FROM results WHERE user_id=? ORDER BY id DESC",
                new String[]{String.valueOf(userId)}
        );

        while (c.moveToNext()) {
            View item = getLayoutInflater().inflate(R.layout.item_history, container, false);

            // Find views
            ImageView imgIcon = item.findViewById(R.id.imgIcon);
            TextView txtTitle = item.findViewById(R.id.txtTitle);
            TextView txtScore = item.findViewById(R.id.txtScore);
            TextView txtDate = item.findViewById(R.id.txtDate);

            // Get data
            String type = c.getString(0);
            int score = c.getInt(1);
            int total = c.getInt(2);
            String date = c.getString(3);

            // Set universal data
            txtScore.setText(score + "/" + total);
            txtDate.setText(date);

            // Set conditional data
            if ("GK".equals(type)) {
                txtTitle.setText("General Knowledge");
                imgIcon.setImageResource(R.drawable.ic_lightbulb);
                item.setBackgroundResource(R.drawable.card_blue);
            } else {
                txtTitle.setText("Science");
                imgIcon.setImageResource(R.drawable.ic_flask);
                item.setBackgroundResource(R.drawable.card_green);
            }

            container.addView(item);
        }

        c.close();


        Button btnHome = findViewById(R.id.btnHome);
        Button btnQuiz = findViewById(R.id.btnQuiz);
        Button btnHistory = findViewById(R.id.btnHistory);
        // 1. Home Button -> Go to MainActivity
        btnHome.setOnClickListener(v -> {
            Intent intent = new Intent(HistoryActivity.this, MainActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });

        // 2. Quiz Button -> Go to QuizActivity
        btnQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(HistoryActivity.this, QuizHomeActivity.class);
            // Clear back stack so pressing back doesn't return to Science
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish(); // Close current activity
        });

        // 3. History Button -> Go to HistoryActivity
        btnHistory.setOnClickListener(v -> {
            Toast.makeText(HistoryActivity.this, "You are already in the Home section", Toast.LENGTH_SHORT).show();
        });
    }
}
