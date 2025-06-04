package com.example.myexpensetracker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    private ArrayList<Expense> expenseList;

    public ExpenseAdapter(ArrayList<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_item, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.amountText.setText("৳ " + expense.getAmount());
        holder.categoryText.setText("Category: " + expense.getCategory());
        holder.noteText.setText("Note: " + expense.getNote());
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView amountText, categoryText, noteText;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            amountText = itemView.findViewById(R.id.amountText);
            categoryText = itemView.findViewById(R.id.categoryText);
            noteText = itemView.findViewById(R.id.noteText);
        }
    }
}