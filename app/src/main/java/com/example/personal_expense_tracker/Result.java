package com.example.personal_expense_tracker;

public class Result {
    String type, date;
    int score, total;

    public Result(String t, int s, int tot, String d) {
        type = t;
        score = s;
        total = tot;
        date = d;
    }
}
