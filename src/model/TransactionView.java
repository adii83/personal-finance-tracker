package model;

public class TransactionView {
    public static void displayInfo(Transaction transaction) {
        System.out.println("--------------------------------");
        System.out.println("Tanggal  : " + transaction.getDate());
        System.out.println("Tipe     : " + transaction.getType());
        System.out.println("Kategori : " + transaction.getCategory());
        System.out.println("Jumlah   : Rp" + transaction.getAmount());
        System.out.println("Catatan  : " + transaction.getNote());
    }
}
