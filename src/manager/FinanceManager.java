package manager;

import java.util.ArrayList;

import model.Transaction;

public class FinanceManager {
    private final ArrayList<Transaction> transactions;
    private final FinanceCalculator financeCalculator;
    private final FinanceReport financeReport;

    public FinanceManager() {
        transactions = new ArrayList<>();
        financeCalculator = new FinanceCalculator();
        financeReport = new FinanceReport(financeCalculator);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaksi berhasil ditambahkan.");
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void showAllTransactions() {
        financeReport.showAllTransactions(transactions);
    }

    public double calculateBalance() {
        return financeCalculator.calculateBalance(transactions);
    }

    public double calculateTotalIncome() {
        return financeCalculator.calculateTotalIncome(transactions);
    }

    public double calculateTotalExpense() {
        return financeCalculator.calculateTotalExpense(transactions);
    }

    public void showReport() {
        financeReport.showReport(transactions);
    }
}
