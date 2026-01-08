package com.example.personal_expense_tracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QuizActivity extends AppCompatActivity {

    TextView txtQuestion, txtTimer;
    EditText edtAnswer;
    Button btnSubmit;

    CountDownTimer timer;

    DatabaseHelper db;
    List<Question> questions;
    int index = 0, score = 0;
    String quizType;

    SessionManager session;
    int USER_ID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        session = new SessionManager(this);
        USER_ID = session.getUserId();

        if (USER_ID == -1) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        quizType = getIntent().getStringExtra("QUIZ_TYPE");

        txtQuestion = findViewById(R.id.txtQuestion);
        edtAnswer = findViewById(R.id.edtAnswer);
        btnSubmit = findViewById(R.id.btnSubmit);
        txtTimer = findViewById(R.id.txtTimer);

        db = new DatabaseHelper(this);
        questions = getRandomQuestions(quizType, 10);

        if (questions.isEmpty()) {
            txtQuestion.setText("No questions found!");
            btnSubmit.setEnabled(false);
            return;
        }

        showQuestion();
        startTimer();

        // ✅ THIS WAS MISSING
        btnSubmit.setOnClickListener(v -> {
            checkAnswer();
            index++;

            if (index < questions.size()) {
                showQuestion();
            } else {
                goToResultPage();
            }
        });
    }



    // ---------------- TIMER ----------------
    void startTimer() {
        timer = new CountDownTimer(600000, 1000) { // 10 minutes
            @Override
            public void onTick(long millisUntilFinished) {
                long minutes = millisUntilFinished / 60000;
                long seconds = (millisUntilFinished % 60000) / 1000;
                txtTimer.setText("Time: " + minutes + ":" + (seconds < 10 ? "0" : "") + seconds);
            }

            @Override
            public void onFinish() {
                goToResultPage();
            }
        }.start();
    }

    // ---------------- QUIZ FLOW ----------------
    void showQuestion() {
        edtAnswer.setText("");
        txtQuestion.setText(questions.get(index).question);
    }

    void checkAnswer() {
        String userAnswer = edtAnswer.getText().toString().trim().toLowerCase();
        if (userAnswer.equals(questions.get(index).answer.toLowerCase())) {
            score++;
        }
    }




    // ---------------- DATABASE ----------------
    void saveResult() {
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("user_id", USER_ID);
        cv.put("quiz_type", quizType);
        cv.put("score", score);
        cv.put("total", questions.size());
        cv.put("date",
                new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date()));
        database.insert("results", null, cv);
    }

    void goToResultPage() {

        if (timer != null) {
            timer.cancel(); // ⛔ stop timer
        }

        saveResult();

        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra("QUIZ_TYPE", quizType);
        intent.putExtra("SCORE", score);
        intent.putExtra("TOTAL", questions.size());

        startActivity(intent);
        finish();
    }


    List<Question> getRandomQuestions(String type, int limit) {
        List<Question> list = new ArrayList<>();
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor c = database.rawQuery(
                "SELECT * FROM questions WHERE quiz_type=? ORDER BY RANDOM() LIMIT ?",
                new String[]{type, String.valueOf(limit)}
        );

        while (c.moveToNext()) {
            list.add(new Question(
                    c.getString(1),
                    c.getString(2)
            ));
        }
        c.close();
        return list;
    }
}
