## Pembagian Branch dan Tanggung Jawab

| Branch / Modul | Nama | NIM | Penerapan SOLID |
| --- | --- | --- | --- |
| `app` | Risky Wahyu Nurdi | 202310370311221 | SRP & DIP |
| `model` | Risky Maulana Virdaus | 202310370311244 | SRP, LSP & ISP |
| `manager` | Slamet Hariyadi | 202310370311221 | SRP, DIP & OCP |

Pembagian oleh masing-masing anggota tim serta prinsip SOLID yang diterapkan pada setiap branch atau modul.

# Personal Finance Tracker

Personal Finance Tracker adalah aplikasi berbasis terminal menggunakan Java untuk membantu pengguna mencatat pemasukan, pengeluaran, melihat saldo, dan menampilkan laporan keuangan sederhana.

Project ini dikembangkan dengan pendekatan Object-Oriented Programming dan refactor menggunakan beberapa prinsip SOLID agar struktur kode lebih rapi, mudah dipahami, dan mudah dikerjakan secara tim.

## Fitur

- Menambahkan transaksi pemasukan
- Menambahkan transaksi pengeluaran
- Menampilkan semua transaksi
- Menghitung saldo akhir
- Menghitung total pemasukan
- Menghitung total pengeluaran
- Menampilkan laporan keuangan sederhana
- Berjalan melalui terminal atau command line

## Tech Stack

- Java
- Git
- GitHub
- Visual Studio Code


## Penerapan SOLID

### App

Modul `app` berperan sebagai pengatur alur aplikasi berbasis terminal. Bagian ini menangani menu, input pengguna, dan menjalankan proses utama aplikasi.

Prinsip yang diterapkan:

- SRP: `MenuView`, `InputHelper`, `FinanceApp`, dan `Main` memiliki tanggung jawab masing-masing.
- DIP: `FinanceApp` menerima dependency utama dari luar melalui constructor sehingga tidak terlalu terikat pada proses pembuatan object.

### Model

Modul `model` berisi representasi data transaksi, seperti pemasukan dan pengeluaran. Bagian ini menjadi dasar data yang digunakan oleh aplikasi.

Prinsip yang diterapkan:

- SRP: setiap class model memiliki tanggung jawab yang fokus terhadap data transaksi.
- LSP: `Income` dan `Expense` dapat digunakan sebagai turunan dari `Transaction` tanpa merusak perilaku utama aplikasi.
- ISP: interface seperti `FinancialTransaction`, `TypedTransaction`, dan `AmountedTransaction` memisahkan kontrak berdasarkan kebutuhan yang lebih spesifik.

### Manager

Modul `manager` berisi pengelolaan transaksi, perhitungan keuangan, dan laporan. Setelah refactor, tanggung jawab yang sebelumnya menumpuk di `FinanceManager` dipisahkan ke class yang lebih fokus.

Prinsip yang diterapkan:

- SRP: `FinanceManager` mengelola transaksi, `FinanceCalculator` menghitung nilai keuangan, dan `FinanceReport` menampilkan laporan.
- DIP: `FinanceReport` menerima `FinanceCalculator` melalui constructor.
- OCP: `FinanceCalculator` menyediakan `calculateTotalByType()` agar perhitungan dapat diperluas berdasarkan tipe transaksi tanpa menambah logika berulang.

## Struktur Project

```text
src
|-- app
|   |-- FinanceApp.java
|   |-- InputHelper.java
|   |-- Main.java
|   `-- MenuView.java
|
|-- manager
|   |-- FinanceCalculator.java
|   |-- FinanceManager.java
|   `-- FinanceReport.java
|
`-- model
    |-- AmountedTransaction.java
    |-- Expense.java
    |-- FinancialTransaction.java
    |-- Income.java
    |-- Transaction.java
    |-- TransactionView.java
    `-- TypedTransaction.java
```

## Cara Menjalankan

Compile semua file Java:

```bash
javac -d out src/app/*.java src/manager/*.java src/model/*.java
```

Jalankan aplikasi:

```bash
java -cp out app.Main
```
