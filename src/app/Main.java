package app;

import manager.FinanceManager;

public class Main {
    public static void main(String[] args) {
        FinanceManager financeManager = new FinanceManager();
        MenuView menuView = new MenuView();
        InputHelper inputHelper = new InputHelper();

        FinanceApp financeApp = new FinanceApp(
                financeManager,
                menuView,
                inputHelper
        );

        financeApp.run();
    }
}
