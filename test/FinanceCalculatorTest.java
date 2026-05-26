import java.util.ArrayList;

import manager.FinanceCalculator;
import model.Transaction;

public class FinanceCalculatorTest {

    public void runAll() {
        testCalculateBalance();
        testCalculateTotalIncomeExpense();
        testCalculateWithEmptyList();
        System.out.println("FinanceCalculatorTest: semua tes lulus.");
    }

    private void testCalculateBalance() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new DummyTransaction("2026-05-27", "Gaji", 5000, "Gaji bulan ini", "INCOME", 5000));
        transactions.add(new DummyTransaction("2026-05-27", "Makan", 1500, "Makan siang", "EXPENSE", -1500));

        double balance = new FinanceCalculator().calculateBalance(transactions);
        assertEquals(3500, balance, "Saldo harus 3500 setelah satu pemasukan dan satu pengeluaran");
    }

    private void testCalculateTotalIncomeExpense() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new DummyTransaction("2026-05-27", "Gaji", 5000, "", "INCOME", 5000));
        transactions.add(new DummyTransaction("2026-05-27", "Bonus", 2000, "", "INCOME", 2000));
        transactions.add(new DummyTransaction("2026-05-27", "Belanja", 1200, "", "EXPENSE", -1200));

        FinanceCalculator calculator = new FinanceCalculator();
        assertEquals(7000, calculator.calculateTotalIncome(transactions), "Total pemasukan harus 7000");
        assertEquals(1200, calculator.calculateTotalExpense(transactions), "Total pengeluaran harus 1200");
    }

    private void testCalculateWithEmptyList() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        FinanceCalculator calculator = new FinanceCalculator();
        assertEquals(0, calculator.calculateBalance(transactions), "Saldo dengan daftar kosong harus 0");
        assertEquals(0, calculator.calculateTotalIncome(transactions), "Pemasukan dengan daftar kosong harus 0");
        assertEquals(0, calculator.calculateTotalExpense(transactions), "Pengeluaran dengan daftar kosong harus 0");
    }

    private void assertEquals(double expected, double actual, String message) {
        double delta = 0.0001;
        if (Math.abs(expected - actual) > delta) {
            throw new AssertionError(message + " (expected=" + expected + ", actual=" + actual + ")");
        }
    }

    private static class DummyTransaction extends Transaction {
        private final String type;
        private final double signedAmount;

        DummyTransaction(String date, String category, double amount, String note, String type, double signedAmount) {
            super(date, category, amount, note);
            this.type = type;
            this.signedAmount = signedAmount;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public double getSignedAmount() {
            return signedAmount;
        }
    }
}
