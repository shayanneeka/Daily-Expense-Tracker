package com.example.myexpensetracker;

public class Expense {
    private int id;
    private double amount;
    private String category;
    private String note;

    public Expense(int id, double amount, String category, String note) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.note = note;
    }

    public int getId() { return id; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getNote() { return note; }
}