Nama  : Slamet Hariyadi

NIM   : 202310370311221

Kelas : Desain Perangkat Lunak B


### Jenis unit testing yang dilakukan

Jenis unit testing yang saya gunakan adalah test double, yaitu:

- Stub
- Dummy

Untuk stub, saya membuat class `StubFinanceCalculator`. Class ini dipakai sebagai pengganti `FinanceCalculator` asli saat proses test.

Jadi pada saat test berjalan, nilai pemasukan, pengeluaran, dan saldo tidak dihitung dari transaksi asli, tetapi langsung saya tentukan dari test. Dengan begitu, hasil yang keluar dari laporan bisa lebih mudah dicek.

Untuk dummy, saya menggunakan `ArrayList<Transaction>` kosong. List ini tetap dikirim ke method `showReport()`, tetapi isi datanya tidak terlalu dipakai karena hasil perhitungannya sudah diatur dari stub.

### Komponen yang dilakukan unit testing

Komponen yang saya lakukan unit testing adalah:

- Package : `manager`
- Class : `FinanceReport`
- Method : `showReport(ArrayList<Transaction> transactions)`

File yang saya tambahkan untuk unit test:

- `FinanceReportTest.java`
- `StubFinanceCalculator.java`
- `TestRunner.java`

### Hasil unit test

<img width="1028" height="599" alt="image" src="https://github.com/user-attachments/assets/7774efc2-88f7-42a5-bb84-dae3244d04b8" />


#### 1. Test laporan aman

Pada test pertama, saya membuat kondisi keuangan masih aman.

Nilai yang saya masukkan lewat stub:

- Total pemasukan : `1000000`
- Total pengeluaran : `250000`
- Saldo akhir : `750000`

Hasil yang dicek:

- Output menampilkan pemasukan `Rp1000000.0`
- Output menampilkan pengeluaran `Rp250000.0`
- Output menampilkan saldo `Rp750000.0`
- Output menampilkan status `Keuangan masih aman.`

#### 2. Test laporan minus

Pada test kedua, saya membuat kondisi pengeluaran lebih besar dari pemasukan.

Nilai yang saya masukkan lewat stub:

- Total pemasukan : `500000`
- Total pengeluaran : `800000`
- Saldo akhir : `-300000`

Hasil yang dicek:

- Output menampilkan pemasukan `Rp500000.0`
- Output menampilkan pengeluaran `Rp800000.0`
- Output menampilkan saldo `Rp-300000.0`
- Output menampilkan status `Pengeluaran lebih besar dari pemasukan.`

### Cara menjalankan unit test

Compile semua file Java termasuk file test:

```bash
javac -d out src/app/*.java src/manager/*.java src/model/*.java src/test/*.java src/test/manager/*.java
```

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
