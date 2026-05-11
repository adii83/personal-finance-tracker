package manager;

import java.util.ArrayList;

import model.Transaction;

public class FinanceCalculator {
    public double calculateBalance(ArrayList<Transaction> transactions) {
        double balance = 0;

        for (Transaction transaction : transactions) {
            balance += transaction.getSignedAmount();
        }

        return balance;
    }

    public double calculateTotalIncome(ArrayList<Transaction> transactions) {
        return calculateTotalByType(transactions, "INCOME");
    }

    public double calculateTotalExpense(ArrayList<Transaction> transactions) {
        return calculateTotalByType(transactions, "EXPENSE");
    }

    public double calculateTotalByType(ArrayList<Transaction> transactions, String type) {
        double total = 0;

        for (Transaction transaction : transactions) {
            if (type.equals(transaction.getType())) {
                total += transaction.getAmount();
            }
        }

        return total;
    }
}
