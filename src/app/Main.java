package app;

import manager.FinanceManager;
import model.Expense;
import model.Income;

public class FinanceApp {

    private FinanceManager financeManager;
    private MenuView menuView;
    private InputHelper inputHelper;

    public FinanceApp() {

        financeManager = new FinanceManager();
        menuView = new MenuView();
        inputHelper = new InputHelper();
    }

    public void run() {

        boolean running = true;

        while (running) {

            menuView.showMenu();

            int choice = inputHelper.inputInt("Pilih menu: ");

            switch (choice) {

                case 1:
                    addIncome();
                    break;

                case 2:
                    addExpense();
                    break;

                case 3:
                    financeManager.showAllTransactions();
                    break;

                case 4:
                    System.out.println(
                            "Saldo saat ini: Rp" +
                            financeManager.calculateBalance()
                    );
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
            }
        }
    }

    private void addIncome() {

        menuView.showIncomeForm();

        String date = inputHelper.input("Tanggal: ");
        String category = inputHelper.input("Kategori: ");
        double amount = inputHelper.inputDouble("Jumlah: ");
        String note = inputHelper.input("Catatan: ");

        Income income = new Income(
                date,
                category,
                amount,
                note
        );

        financeManager.addTransaction(income);
    }

    private void addExpense() {

        menuView.showExpenseForm();

        String date = inputHelper.input("Tanggal: ");
        String category = inputHelper.input("Kategori: ");
        double amount = inputHelper.inputDouble("Jumlah: ");
        String note = inputHelper.input("Catatan: ");

        Expense expense = new Expense(
                date,
                category,
                amount,
                note
        );

        financeManager.addTransaction(expense);
    }
}