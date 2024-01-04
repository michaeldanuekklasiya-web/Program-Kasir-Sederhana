package com.example.program_kasir_sederhana;

import javafx.collections.ObservableList;

public interface Transaksii {
    // Menambahkan metode untuk mendapatkan informasi produk
    String getNamaProduk();

    // Menambahkan metode untuk mendapatkan jumlah barang
    int getJumlahBarang();

    // Menambahkan metode untuk mendapatkan total bayar
    double getTotalBayar();

    // Menambahkan metode untuk mendapatkan data transaksi
    ObservableList<Transaksi> getHistoryData();

    // Menambahkan metode untuk memproses transaksi
    void prosesTransaksi(Transaksi transaksi);
}
