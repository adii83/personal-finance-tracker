package app;

import manager.FinanceManager;
import model.Transaction;

public class FinanceApp {

    private FinanceManager financeManager;
    private MenuView menuView;
    private InputHelper inputHelper;
    private TransactionFactory factory;

    public FinanceApp(
            FinanceManager financeManager,
            MenuView menuView,
            InputHelper inputHelper,
            TransactionFactory factory
    ) {

        this.financeManager = financeManager;
        this.menuView = menuView;
        this.inputHelper = inputHelper;
        this.factory = factory;
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

        Transaction income = factory.createIncome(
                inputHelper.input("Tanggal: "),
                inputHelper.input("Kategori: "),
                inputHelper.inputDouble("Jumlah: "),
                inputHelper.input("Catatan: ")
        );

        financeManager.addTransaction(income);
    }

    private void addExpense() {

        menuView.showExpenseForm();

        Transaction expense = factory.createExpense(
                inputHelper.input("Tanggal: "),
                inputHelper.input("Kategori: "),
                inputHelper.inputDouble("Jumlah: "),
                inputHelper.input("Catatan: ")
        );

        financeManager.addTransaction(expense);
    }
}