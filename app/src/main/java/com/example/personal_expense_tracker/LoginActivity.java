package com.example.personal_expense_tracker;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    DatabaseHelper db;
    SessionManager session;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_login);

        db = new DatabaseHelper(this);
        session = new SessionManager(this);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);

        //  LOGIN BUTTON
        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            SQLiteDatabase database = db.getReadableDatabase();

            Cursor c = database.rawQuery(
                    "SELECT id, username FROM users WHERE email=? AND password=?",
                    new String[]{
                            edtEmail.getText().toString().trim(),
                            edtPassword.getText().toString().trim()
                    });

            if (c.moveToFirst()) {
                int id = c.getInt(0);
                String name = c.getString(1);

                session.saveUser(id, name);

                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
            c.close();
        });

        // GO TO REGISTER
        TextView txtGotoRegister = findViewById(R.id.txtGoToRegister);
        txtGotoRegister.setOnClickListener(v ->
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class))
        );
    }
}
