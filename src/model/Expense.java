package model;

public class Expense extends Transaction {

    public Expense(String date, String category, double amount, String note) {
        super(date, category, amount, note);
    }

    @Override
    public String getType() {
        return "EXPENSE";
    }

    @Override
    public double getSignedAmount() {
        return -getAmount();
    }
}