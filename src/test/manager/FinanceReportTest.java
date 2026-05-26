package test.manager;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import manager.FinanceReport;
import model.Transaction;

public class FinanceReportTest {

    public static void runTests() {
        testLaporanAman();
        testLaporanMinus();
    }

    private static void testLaporanAman() {
        StubFinanceCalculator hitungStub = new StubFinanceCalculator(1000000, 250000, 750000);
        FinanceReport report = new FinanceReport(hitungStub);
        ArrayList<Transaction> dataDummy = new ArrayList<>();
        ByteArrayOutputStream tampungOutput = new ByteArrayOutputStream();
        PrintStream outputAwal = System.out;

        try {
            System.setOut(new PrintStream(tampungOutput));
            report.showReport(dataDummy);
            String hasil = tampungOutput.toString();
            if (!hasil.contains("Total Pemasukan   : Rp1000000.0")) {
                throw new AssertionError("Pemasukan belum sesuai");
            }
            if (!hasil.contains("Total Pengeluaran : Rp250000.0")) {
                throw new AssertionError("Pengeluaran belum sesuai");
            }
            if (!hasil.contains("Saldo Akhir       : Rp750000.0")) {
                throw new AssertionError("Saldo akhir belum sesuai");
            }
            if (!hasil.contains("Status            : Keuangan masih aman.")) {
                throw new AssertionError("Status laporan belum sesuai");
            }
            System.setOut(outputAwal);
            System.out.println("-> Cek laporan aman");
            System.out.println("Hasil report:");
            System.out.print(hasil);
            System.out.println("Angka dan status sudah sesuai");
            System.out.println("Test laporan aman : Joss(OK)\n");

        } finally {
            System.setOut(outputAwal);
        }
    }

    private static void testLaporanMinus() {
        StubFinanceCalculator hitungStub = new StubFinanceCalculator(500000, 800000, -300000);
        FinanceReport report = new FinanceReport(hitungStub);
        ArrayList<Transaction> dataDummy = new ArrayList<>();
        ByteArrayOutputStream tampungOutput = new ByteArrayOutputStream();
        PrintStream outputAwal = System.out;

        try {
            System.setOut(new PrintStream(tampungOutput));
            report.showReport(dataDummy);
            String hasil = tampungOutput.toString();
            if (!hasil.contains("Total Pemasukan   : Rp500000.0")) {
                throw new AssertionError("Pemasukan belum sesuai");
            }
            if (!hasil.contains("Total Pengeluaran : Rp800000.0")) {
                throw new AssertionError("Pengeluaran belum sesuai");
            }
            if (!hasil.contains("Saldo Akhir       : Rp-300000.0")) {
                throw new AssertionError("Saldo akhir belum sesuai");
            }
            if (!hasil.contains("Status            : Pengeluaran lebih besar dari pemasukan.")) {
                throw new AssertionError("status laporan salah");
            }
            System.setOut(outputAwal);
            System.out.println("->Cek laporan minus");
            System.out.println("Hasil report:");
            System.out.print(hasil);
            System.out.println("Angka dan status sudah sesuai");
            System.out.println("Test laporan minus : Joss(OK)\n");

        } finally {
            System.setOut(outputAwal);
        }
    }
}
