package manager;

import java.util.ArrayList;

import model.Transaction;

public class FinanceManager {
    private ArrayList<Transaction> transactions;

    public FinanceManager() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        System.out.println("Transaksi berhasil ditambahkan.");
    }

    public void showAllTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        System.out.println("\n=== DAFTAR TRANSAKSI ===");

        for (Transaction transaction : transactions) {
            transaction.displayInfo();
        }
    }

    public double calculateBalance() {
        double balance = 0;

        for (Transaction transaction : transactions) {
            balance += transaction.getSignedAmount();
        }

        return balance;
    }

    public double calculateTotalIncome() {
        double totalIncome = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("INCOME")) {
                totalIncome += transaction.getAmount();
            }
        }

        return totalIncome;
    }

    public double calculateTotalExpense() {
        double totalExpense = 0;

        for (Transaction transaction : transactions) {
            if (transaction.getType().equals("EXPENSE")) {
                totalExpense += transaction.getAmount();
            }
        }

        return totalExpense;
    }

    public void showReport() {
        double totalIncome = calculateTotalIncome();
        double totalExpense = calculateTotalExpense();
        double balance = calculateBalance();

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

    /*
     * TODO SOLID - SRP:
     * Class ini punya terlalu banyak tanggung jawab:
     * 1. Menyimpan transaksi
     * 2. Menambahkan transaksi
     * 3. Menampilkan transaksi
     * 4. Menghitung saldo
     * 5. Menghitung total pemasukan
     * 6. Menghitung total pengeluaran
     * 7. Menampilkan laporan
     *
     * Setelah SOLID, class ini akan dipecah menjadi:
     * - TransactionRepository
     * - TransactionService
     * - BalanceService
     * - ReportService
     * - TransactionView
     * - ReportView
     *
     * TODO SOLID - DIP:
     * Class ini langsung bergantung pada ArrayList.
     * Setelah SOLID, penyimpanan transaksi akan menggunakan interface repository.
     *
     * TODO SOLID - OCP:
     * Method calculateTotalIncome() dan calculateTotalExpense()
     * masih bergantung pada string "INCOME" dan "EXPENSE".
     * Jika ada tipe transaksi baru, kemungkinan class ini harus diubah.
     */
}