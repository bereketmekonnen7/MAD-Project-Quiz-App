package com.example.personal_expense_tracker;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    Context context;
    List<Result> list;

    public HistoryAdapter(Context c, List<Result> l) {
        context = c;
        list = l;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup p, int v) {
        return new ViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_history, p, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder h, int i) {
        Result r = list.get(i);

        h.txtTitle.setText(r.type);
        h.txtScore.setText(r.score + "/" + r.total);
        h.txtDate.setText(r.date);

        if (r.type.equals("SCIENCE")) {
            h.card.setCardBackgroundColor(Color.parseColor("#7CFFB2"));
            h.img.setImageResource(R.drawable.ic_flask);
        } else {
            h.card.setCardBackgroundColor(Color.parseColor("#87AFFF"));
            h.img.setImageResource(R.drawable.ic_lightbulb);
        }
    }

    @Override
    public int getItemCount() { return list.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle, txtScore, txtDate;
        ImageView img;
        CardView card;

        ViewHolder(View v) {
            super(v);
//            card = v.findViewById(R.id.card);
            img = v.findViewById(R.id.imgIcon);
//            txtTitle = v.findViewById(R.id.txtType);
            txtScore = v.findViewById(R.id.txtScore);
            txtDate = v.findViewById(R.id.txtDate);
        }
    }
}
