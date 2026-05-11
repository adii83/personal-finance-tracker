package app;

public class Main {

    /*
     * ==============================
     * SOLID PRINCIPLE IMPLEMENTATION
     * ==============================
     *
     * SRP (Single Responsibility Principle)
     * -------------------------------------
     * Main hanya bertugas menjalankan aplikasi.
     *
     * Sebelumnya Main menangani:
     * - Menu
     * - Input user
     * - Switch case
     * - Membuat object transaksi
     * - Logika aplikasi
     *
     * Setelah SRP:
     * - FinanceApp     -> mengatur alur aplikasi
     * - MenuView       -> menampilkan menu
     * - InputHelper    -> menangani input
     * - TransactionFactory -> membuat object transaksi
     *
     *
     * DIP (Dependency Inversion Principle)
     * ------------------------------------
     * Main tidak bergantung langsung pada:
     * - Scanner
     * - FinanceManager
     * - Income
     * - Expense
     *
     * Main hanya bergantung pada abstraction
     * berupa FinanceApp.
     */

    public static void main(String[] args) {

        FinanceManager manager = new FinanceManager();

        MenuView menuView = new MenuView();

        InputHelper inputHelper = new InputHelper();

        TransactionFactory factory = new TransactionFactory();

        FinanceApp app = new FinanceApp(
                manager,
                menuView,
                inputHelper,
                factory
        );

        app.run();
    }
}