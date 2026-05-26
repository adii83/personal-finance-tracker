public class TestRunner {

    public static void main(String[] args) {
        int failed = 0;

        failed += runTestClass(new FinanceCalculatorTest());
        failed += runTestClass(new FinanceReportTest());
        failed += runTestClass(new FinanceAppTest());

        System.out.println("============================");
        if (failed == 0) {
            System.out.println("Semua test lulus.");
        } else {
            System.out.println("Test gagal: " + failed);
            System.exit(1);
        }
    }

    private static int runTestClass(Object testClass) {
        try {
            if (testClass instanceof FinanceCalculatorTest) {
                ((FinanceCalculatorTest) testClass).runAll();
            } else if (testClass instanceof FinanceReportTest) {
                ((FinanceReportTest) testClass).runAll();
            } else if (testClass instanceof FinanceAppTest) {
                ((FinanceAppTest) testClass).runAll();
            }
            return 0;
        } catch (AssertionError error) {
            System.err.println("Test gagal: " + error.getMessage());
            return 1;
        } catch (Exception exception) {
            System.err.println("Exception saat menjalankan test: " + exception);
            exception.printStackTrace(System.err);
            return 1;
        }
    }
}
