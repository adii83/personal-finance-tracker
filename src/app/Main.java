package app;

import java.util.Scanner;

import manager.FinanceManager;
import model.Expense;
import model.Income;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceManager financeManager = new FinanceManager();

        boolean running = true;

        while (running) {
            System.out.println("\n=== PERSONAL FINANCE TRACKER ===");
            System.out.println("1. Tambah Pemasukan");
            System.out.println("2. Tambah Pengeluaran");
            System.out.println("3. Lihat Semua Transaksi");
            System.out.println("4. Lihat Saldo");
            System.out.println("5. Lihat Laporan");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n=== TAMBAH PEMASUKAN ===");

                    System.out.print("Tanggal: ");
                    String incomeDate = scanner.nextLine();

                    System.out.print("Kategori: ");
                    String incomeCategory = scanner.nextLine();

                    System.out.print("Jumlah: ");
                    double incomeAmount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Catatan: ");
                    String incomeNote = scanner.nextLine();

                    Income income = new Income(
                            incomeDate,
                            incomeCategory,
                            incomeAmount,
                            incomeNote
                    );

                    financeManager.addTransaction(income);
                    break;

                case 2:
                    System.out.println("\n=== TAMBAH PENGELUARAN ===");

                    System.out.print("Tanggal: ");
                    String expenseDate = scanner.nextLine();

                    System.out.print("Kategori: ");
                    String expenseCategory = scanner.nextLine();

                    System.out.print("Jumlah: ");
                    double expenseAmount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Catatan: ");
                    String expenseNote = scanner.nextLine();

                    Expense expense = new Expense(
                            expenseDate,
                            expenseCategory,
                            expenseAmount,
                            expenseNote
                    );

                    financeManager.addTransaction(expense);
                    break;

                case 3:
                    financeManager.showAllTransactions();
                    break;

                case 4:
                    System.out.println("Saldo saat ini: Rp" + financeManager.calculateBalance());
                    break;

                case 5:
                    financeManager.showReport();
                    break;

                case 6:
                    running = false;
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Menu tidak valid.");
                    break;
            }
        }

        scanner.close();

        /*
         * TODO SOLID - SRP:
         * Main terlalu banyak menangani hal:
         * 1. Menampilkan menu
         * 2. Membaca input
         * 3. Membuat object Income dan Expense
         * 4. Mengatur switch case
         * 5. Menghubungkan user dengan FinanceManager
         *
         * Setelah SOLID, alur program akan dipindahkan ke FinanceApp,
         * tampilan menu ke MenuView, dan input ke InputHelper.
         *
         * TODO SOLID - DIP:
         * Main langsung bergantung pada class konkret FinanceManager,
         * Income, Expense, dan Scanner.
         * Setelah SOLID, Main cukup menjalankan FinanceApp.
         */
    }
}