package com.example.myexpensetracker;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddExpenseActivity extends AppCompatActivity {

    private EditText editTextAmount, editTextCategory, editTextNote;
    private Button buttonSave;
    private ExpenseDbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense); // This must match your XML file name

        editTextAmount = findViewById(R.id.editTextAmount);
        editTextCategory = findViewById(R.id.editTextCategory);
        editTextNote = findViewById(R.id.editTextNote);
        buttonSave = findViewById(R.id.buttonSave);

        dbHelper = new ExpenseDbHelper(this);

        buttonSave.setOnClickListener(v -> {
            String amountText = editTextAmount.getText().toString();
            String category = editTextCategory.getText().toString();
            String note = editTextNote.getText().toString();

            if (TextUtils.isEmpty(amountText) || TextUtils.isEmpty(category)) {
                Toast.makeText(this, "Amount and Category are required", Toast.LENGTH_SHORT).show();
                return;
            }

            double amount = Double.parseDouble(amountText);

            Expense expense = new Expense(0, amount, category, note);
            dbHelper.addExpense(expense);

            Toast.makeText(this, "Expense saved!", Toast.LENGTH_SHORT).show();
            finish(); // Closes AddExpenseActivity and returns to MainActivity
        });
    }
}
