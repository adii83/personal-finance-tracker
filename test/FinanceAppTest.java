import app.FinanceApp;
import app.InputHelper;
import app.MenuView;
import manager.FinanceManager;
import model.Expense;
import model.Transaction;
import model.Income;

public class FinanceAppTest {

    public void runAll() {
        testAddIncomeExpenseFlow();
        System.out.println("FinanceAppTest: semua tes lulus.");
    }

    private void testAddIncomeExpenseFlow() {
        FakeInputHelper inputHelper = new FakeInputHelper(
                new int[]{1, 2, 4, 6},
                new String[]{
                        "2026-05-27", "Gaji", "Gaji bulanan", "2026-05-28", "Makan", "Makan siang"
                },
                new double[]{5000, 1500}
        );
        DummyMenuView menuView = new DummyMenuView();
        SpyFinanceManager manager = new SpyFinanceManager();

        FinanceApp app = new FinanceApp(manager, menuView, inputHelper);
        app.run();

        assertEquals(2, manager.addCount, "Manager harus menerima dua transaksi");
        assertEquals(1, manager.balanceCount, "Saldo harus dihitung sekali saat program menampilkan saldo");
        assertEquals(3500, manager.calculateBalance(), "Saldo akhir harus 3500 setelah dua transaksi");
    }

    private void assertEquals(double expected, double actual, String message) {
        double delta = 0.0001;
        if (Math.abs(expected - actual) > delta) {
            throw new AssertionError(message + " (expected=" + expected + ", actual=" + actual + ")");
        }
    }

    private void assertEquals(int expected, int actual, String message) {
        if (expected != actual) {
            throw new AssertionError(message + " (expected=" + expected + ", actual=" + actual + ")");
        }
    }

    private static class FakeInputHelper extends InputHelper {
        private final int[] ints;
        private final String[] strings;
        private final double[] doubles;
        private int intIndex = 0;
        private int stringIndex = 0;
        private int doubleIndex = 0;

        FakeInputHelper(int[] ints, String[] strings, double[] doubles) {
            this.ints = ints;
            this.strings = strings;
            this.doubles = doubles;
        }

        @Override
        public String input(String message) {
            if (stringIndex >= strings.length) {
                return "";
            }
            return strings[stringIndex++];
        }

        @Override
        public int inputInt(String message) {
            if (intIndex >= ints.length) {
                return 6;
            }
            return ints[intIndex++];
        }

        @Override
        public double inputDouble(String message) {
            if (doubleIndex >= doubles.length) {
                return 0;
            }
            return doubles[doubleIndex++];
        }
    }

    private static class DummyMenuView extends MenuView {
        @Override
        public void showMenu() {
            // Dummy: hanya mengisi dependency, tidak perlu output nyata
        }

        @Override
        public void showIncomeForm() {
            // Dummy
        }

        @Override
        public void showExpenseForm() {
            // Dummy
        }
    }

    private static class SpyFinanceManager extends FinanceManager {
        public int addCount = 0;
        public int balanceCount = 0;
        public int showAllCount = 0;
        public int showReportCount = 0;

        @Override
        public void addTransaction(Transaction transaction) {
            addCount++;
            super.addTransaction(transaction);
        }

        @Override
        public double calculateBalance() {
            balanceCount++;
            return super.calculateBalance();
        }

        @Override
        public void showAllTransactions() {
            showAllCount++;
            super.showAllTransactions();
        }

        @Override
        public void showReport() {
            showReportCount++;
            super.showReport();
        }
    }
}
