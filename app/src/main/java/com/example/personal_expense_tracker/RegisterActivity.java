package com.example.personal_expense_tracker;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edtUsername, edtEmail, edtPassword;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);

        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        findViewById(R.id.btnRegister).setOnClickListener(v -> {
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues cv = new ContentValues();

            cv.put("username", edtUsername.getText().toString());
            cv.put("email", edtEmail.getText().toString());
            cv.put("password", edtPassword.getText().toString());

            database.insert("users", null, cv);
            finish();
        });
    }
}

