package model;

public abstract class Transaction {
    private String date;
    private String category;
    private double amount;
    private String note;

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

    public abstract String getType();

    public abstract double getSignedAmount();



    /*
     * TODO SOLID - SRP:
     * Class Transaction seharusnya fokus sebagai model data transaksi.
     * Saat ini class ini juga menangani tampilan melalui method displayInfo().
     * Setelah SOLID, displayInfo() akan dipindahkan ke class view, misalnya TransactionView.
     */
}