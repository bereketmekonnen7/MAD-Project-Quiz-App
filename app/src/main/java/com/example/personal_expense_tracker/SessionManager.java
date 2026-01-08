package com.example.personal_expense_tracker;


import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String PREF = "quiz_session";
    // Define keys as constants to avoid mismatch
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USERNAME = "username";

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    public SessionManager(Context c) {
        sp = c.getSharedPreferences(PREF, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void saveUser(int id, String username) {
        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USERNAME, username);
        editor.apply(); // Changes are saved asynchronously
    }

    public String getUsername() {
        return sp.getString(KEY_USERNAME, "Guest");
    }

    public int getUserId() {
        return sp.getInt(KEY_USER_ID, -1);
    }

    public void logout() {
        editor.clear().apply();
    }
}

