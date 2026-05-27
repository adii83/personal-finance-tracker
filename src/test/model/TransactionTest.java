package test.model;

import java.util.ArrayList;

import manager.FinanceCalculator;
import model.Income;
import model.Expense;
import model.Transaction;

public class TransactionTest {

    public static void main(String[] args) {
        TransactionTest test = new TransactionTest();

        System.out.println("Mulai pengujian TransactionTest...");

        int passed = 0;
        int failed = 0;

        if (runTest(() -> test.testIncome_HarusMengembalikanNilaiPositif(), "testIncome_HarusMengembalikanNilaiPositif")) {
            passed++;
        } else {
            failed++;
        }

        if (runTest(() -> test.testExpense_HarusMengembalikanNilaiNegatif(), "testExpense_HarusMengembalikanNilaiNegatif")) {
            passed++;
        } else {
            failed++;
        }

        if (runTest(() -> test.testStubTransactionHitungBalance(), "testStubTransactionHitungBalance")) {
            passed++;
        } else {
            failed++;
        }

        System.out.println("Ringkasan: Passed=" + passed + " Failed=" + failed);
        if (failed == 0) {
            System.out.println("Semua pengujian TransactionTest berhasil.");
        } else {
            System.out.println("Beberapa pengujian gagal. Periksa output di atas untuk detail.");
        }
    }

    private static boolean runTest(Runnable testMethod, String testName) {
        System.out.println("  Menjalankan: " + testName + " ...");
        long start = System.currentTimeMillis();
        try {
            testMethod.run();
            long duration = System.currentTimeMillis() - start;
            System.out.println("PASSED: " + testName + " (" + duration + " ms)");
            return true;
        } catch (AssertionError ae) {
            long duration = System.currentTimeMillis() - start;
            System.out.println("FAILED: " + testName + " (" + duration + " ms)");
            System.out.println("  Reason: " + ae.getMessage());
            return false;
        } catch (Exception e) {
            long duration = System.currentTimeMillis() - start;
            System.out.println("ERROR: " + testName + " (" + duration + " ms)");
            System.out.println("  Exception: " + e.toString());
            return false;
        }
    }

    public void testIncome_HarusMengembalikanNilaiPositif() {
        Income pemasukan = new Income("2026-05-25", "Gaji", 5000000, "Gaji Bulanan");
        double ekspektasi = 5000000.0;

        double aktual = pemasukan.getSignedAmount();

        assertEquals(ekspektasi, aktual, "Error: Nilai signed amount untuk Income harus tetap positif!");
    }

    public void testExpense_HarusMengembalikanNilaiNegatif() {
        Expense pengeluaran = new Expense("2026-05-26", "Makanan", 50000, "Makan Siang");
        double ekspektasi = -50000.0; 

        
        double aktual = pengeluaran.getSignedAmount();

        
        assertEquals(ekspektasi, aktual, "Error: Nilai signed amount untuk Expense harus menjadi negatif!");
    }

    public void testStubTransactionHitungBalance() {
        FinanceCalculator calculator = new FinanceCalculator();
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new StubTransaction("INCOME", 120000));
        transactions.add(new StubTransaction("EXPENSE", 50000));

        double ekspektasi = 70000.0;
        double aktual = calculator.calculateBalance(transactions);

        assertEquals(ekspektasi, aktual, "Error: StubTransaction harus membuat perhitungan saldo yang dapat diuji.");
    }

    private static void assertEquals(double expected, double actual, String message) {
        if (Double.compare(expected, actual) != 0) {
            throw new AssertionError(message + " expected=" + expected + " actual=" + actual);
        }
    }

    private static class StubTransaction extends Transaction {
        private final String type;

        public StubTransaction(String type, double amount) {
            super("2026-05-27", "Stub", amount, "Stub transaction");
            this.type = type;
        }

        @Override
        public String getType() {
            return type;
        }

        @Override
        public double getSignedAmount() {
            return "INCOME".equals(type) ? getAmount() : -getAmount();
        }
    }
}
