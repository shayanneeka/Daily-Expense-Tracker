package com.example.myexpensetracker;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView expenseList;
    private ExpenseAdapter adapter;
    private ExpenseDbHelper dbHelper;
    private ArrayList<Expense> expenses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        Button addButton = findViewById(R.id.addButton);
        expenseList = findViewById(R.id.expenseList);

        // DB Helper
        dbHelper = new ExpenseDbHelper(this);

        // Load expenses
        loadExpenses();

        // Add Expense button click
        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
            startActivity(intent);
        });
    }

    // Reload expenses when returning from AddExpenseActivity
    @Override
    protected void onResume() {
        super.onResume();
        loadExpenses();
    }

    private void loadExpenses() {
        expenses = dbHelper.getAllExpenses();
        adapter = new ExpenseAdapter(expenses);
        expenseList.setLayoutManager(new LinearLayoutManager(this));
        expenseList.setAdapter(adapter);
    }
}