package test;
import test.manager.FinanceReportTest;
public class TestRunner {

    public static void main(String[] args) {
        System.out.println("Start Test:");
        System.out.println();
        try {
            FinanceReportTest.runTests();
            System.out.println();
            System.out.println("Semua test jalan: Aman");
        } catch (AssertionError e) {
            System.out.println();
            System.out.println("Ada test gagal: " + e.getMessage());
            System.exit(1);
        } catch (Exception e) {
            System.out.println();
            System.out.println("Error waktu test: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}