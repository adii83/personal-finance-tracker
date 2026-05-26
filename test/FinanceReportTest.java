import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import manager.FinanceCalculator;
import manager.FinanceReport;
import model.Transaction;

public class FinanceReportTest {

    public void runAll() {
        testShowReportUsesStubCalculator();
        testMockCalculatorCalls();
        System.out.println("FinanceReportTest: semua tes lulus.");
    }

    private void testShowReportUsesStubCalculator() {
        FinanceCalculator stubCalculator = new FinanceCalculatorStub();
        FinanceReport report = new FinanceReport(stubCalculator);

        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(buffer));

        try {
            report.showReport(new ArrayList<>());
        } finally {
            System.setOut(originalOut);
        }

        String output = buffer.toString();
        assertContains(output, "Total Pemasukan   : Rp2000.0", "Output harus menampilkan total pemasukan 2000");
        assertContains(output, "Total Pengeluaran : Rp2500.0", "Output harus menampilkan total pengeluaran 2500");
        assertContains(output, "Saldo Akhir       : Rp-500.0", "Output harus menampilkan saldo -500");
        assertContains(output, "Pengeluaran lebih besar dari pemasukan.", "Output harus menampilkan status pengeluaran lebih besar dari pemasukan");
    }

    private void testMockCalculatorCalls() {
        MockFinanceCalculator mockCalculator = new MockFinanceCalculator();
        FinanceReport report = new FinanceReport(mockCalculator);
        report.showReport(new ArrayList<>());

        assertEquals(1, mockCalculator.incomeCalls, "calculateTotalIncome harus dipanggil sekali");
        assertEquals(1, mockCalculator.expenseCalls, "calculateTotalExpense harus dipanggil sekali");
        assertEquals(1, mockCalculator.balanceCalls, "calculateBalance harus dipanggil sekali");
    }

    private void assertContains(String text, String expected, String message) {
        if (!text.contains(expected)) {
            throw new AssertionError(message + " (expected text not ditemukan: " + expected + ")");
        }
    }

    private void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " (expected=" + expected + ", actual=" + actual + ")");
        }
    }

    private static class FinanceCalculatorStub extends FinanceCalculator {
        @Override
        public double calculateTotalIncome(ArrayList<Transaction> transactions) {
            return 2000;
        }

        @Override
        public double calculateTotalExpense(ArrayList<Transaction> transactions) {
            return 2500;
        }

        @Override
        public double calculateBalance(ArrayList<Transaction> transactions) {
            return -500;
        }
    }

    private static class MockFinanceCalculator extends FinanceCalculator {
        public int incomeCalls = 0;
        public int expenseCalls = 0;
        public int balanceCalls = 0;

        @Override
        public double calculateTotalIncome(ArrayList<Transaction> transactions) {
            incomeCalls++;
            return 1;
        }

        @Override
        public double calculateTotalExpense(ArrayList<Transaction> transactions) {
            expenseCalls++;
            return 1;
        }

        @Override
        public double calculateBalance(ArrayList<Transaction> transactions) {
            balanceCalls++;
            return 0;
        }
    }
}
