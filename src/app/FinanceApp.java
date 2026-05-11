package app;

import manager.FinanceManager;
import model.Expense;
import model.Income;
import model.Transaction;

public class FinanceApp {

    private final FinanceManager financeManager;
    private final MenuView menuView;
    private final InputHelper inputHelper;

    public FinanceApp(
            FinanceManager financeManager,
            MenuView menuView,
            InputHelper inputHelper
    ) {

        this.financeManager = financeManager;
        this.menuView = menuView;
        this.inputHelper = inputHelper;
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

        Transaction income = new Income(
                inputHelper.input("Tanggal: "),
                inputHelper.input("Kategori: "),
                inputHelper.inputDouble("Jumlah: "),
                inputHelper.input("Catatan: ")
        );

        financeManager.addTransaction(income);
    }

    private void addExpense() {

        menuView.showExpenseForm();

        Transaction expense = new Expense(
                inputHelper.input("Tanggal: "),
                inputHelper.input("Kategori: "),
                inputHelper.inputDouble("Jumlah: "),
                inputHelper.input("Catatan: ")
        );

        financeManager.addTransaction(expense);
    }
}
