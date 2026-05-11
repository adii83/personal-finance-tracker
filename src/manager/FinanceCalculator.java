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
        double totalIncome = 0;

        for (Transaction transaction : transactions) {
            if ("INCOME".equals(transaction.getType())) {
                totalIncome += transaction.getAmount();
            }
        }

        return totalIncome;
    }

    public double calculateTotalExpense(ArrayList<Transaction> transactions) {
        double totalExpense = 0;

        for (Transaction transaction : transactions) {
            if ("EXPENSE".equals(transaction.getType())) {
                totalExpense += transaction.getAmount();
            }
        }

        return totalExpense;
    }
}
