package manager;

import java.util.ArrayList;

import model.Transaction;

public class FinanceManager {
    private final ArrayList<Transaction> transactions;

    public FinanceManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaksi berhasil ditambahkan.");
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
