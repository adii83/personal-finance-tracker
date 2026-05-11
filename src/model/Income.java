package model;

public class Income extends Transaction {

    public Income(String date, String category, double amount, String note) {
        super(date, category, amount, note);
    }

    @Override
    public String getType() {
        return "INCOME";
    }

    @Override
    public double getSignedAmount() {
        return getAmount();
    }
}