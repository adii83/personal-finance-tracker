package test.manager;
import java.util.ArrayList;
import manager.FinanceCalculator;
import model.Transaction;

public class StubFinanceCalculator extends FinanceCalculator {

    private double pemasukan;
    private double pengeluaran;
    private double saldo;
    public StubFinanceCalculator(double pemasukan, double pengeluaran, double saldo) {
        this.pemasukan = pemasukan;
        this.pengeluaran = pengeluaran;
        this.saldo = saldo;
    }
    
    @Override
    public double calculateTotalIncome(ArrayList<Transaction> transactions) {
        return pemasukan;
    }
    @Override
    public double calculateTotalExpense(ArrayList<Transaction> transactions) {
        return pengeluaran;
    }
    @Override
    public double calculateBalance(ArrayList<Transaction> transactions) {
        return saldo;
    }
}