package model;

public abstract class Transaction implements FinancialTransaction,TypedTransaction,AmountedTransaction {
    private final String date;
    private final String category;
    private final double amount;
    private final String note;

    public Transaction(String date, String category, double amount, String note) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.note = note;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getNote() {
        return note;
    }

    @Override
    public abstract String getType();
    
    @Override
    public abstract double getSignedAmount();

        



}