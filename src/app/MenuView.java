package app;

public class MenuView {

    public void showMenu() {

        System.out.println("\n=== PERSONAL FINANCE TRACKER ===");
        System.out.println("1. Tambah Pemasukan");
        System.out.println("2. Tambah Pengeluaran");
        System.out.println("3. Lihat Semua Transaksi");
        System.out.println("4. Lihat Saldo");
        System.out.println("5. Lihat Laporan");
        System.out.println("6. Keluar");
    }

    public void showIncomeForm() {
        System.out.println("\n=== TAMBAH PEMASUKAN ===");
    }

    public void showExpenseForm() {
        System.out.println("\n=== TAMBAH PENGELUARAN ===");
    }
}