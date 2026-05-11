package manager;

import java.util.ArrayList;

import model.Transaction;

public class FinanceReport {
    private final FinanceCalculator financeCalculator;

    public FinanceReport() {
        this.financeCalculator = new FinanceCalculator();
    }

    public void showAllTransactions(ArrayList<Transaction> transactions) {
        if (transactions.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n=== DAFTAR TRANSAKSI ===");

        for (Transaction transaction : transactions) {
            transaction.displayInfo();
        }
    }

    public void showReport(ArrayList<Transaction> transactions) {
        double totalIncome = financeCalculator.calculateTotalIncome(transactions);
        double totalExpense = financeCalculator.calculateTotalExpense(transactions);
        double balance = financeCalculator.calculateBalance(transactions);

        System.out.println("\n=== LAPORAN KEUANGAN ===");
        System.out.println("Total Pemasukan   : Rp" + totalIncome);
        System.out.println("Total Pengeluaran : Rp" + totalExpense);
        System.out.println("Saldo Akhir       : Rp" + balance);

        if (totalExpense > totalIncome) {
            System.out.println("Status            : Pengeluaran lebih besar dari pemasukan.");
        } else {
            System.out.println("Status            : Keuangan masih aman.");
        }
    }
}
