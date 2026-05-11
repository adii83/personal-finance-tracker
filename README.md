# Personal Finance Tracker

Personal Finance Tracker adalah aplikasi berbasis terminal yang dibuat menggunakan Java untuk membantu pengguna mencatat pemasukan, pengeluaran, melihat saldo, dan membuat laporan keuangan sederhana.

Project ini dikembangkan dengan pendekatan Object-Oriented Programming dan dirancang agar dapat dikembangkan secara bertahap. Versi awal berfokus pada fitur utama aplikasi, kemudian struktur kode akan ditingkatkan melalui refactor menggunakan prinsip SOLID.

## Features

Fitur utama aplikasi:

- Menambahkan transaksi pemasukan
- Menambahkan transaksi pengeluaran
- Menampilkan semua transaksi
- Menghitung saldo akhir
- Menghitung total pemasukan
- Menghitung total pengeluaran
- Menampilkan laporan keuangan sederhana
- Berjalan melalui terminal atau command line

## Tech Stack

Project ini menggunakan:

- Java
- Git
- GitHub
- Visual Studio Code

## Project Structure

Struktur folder versi awal:

```text
src
├── app
│   └── Main.java
│
├── model
│   ├── Transaction.java
│   ├── Income.java
│   └── Expense.java
│
└── manager
    └── FinanceManager.java