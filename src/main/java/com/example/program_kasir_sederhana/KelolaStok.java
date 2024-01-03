package com.example.program_kasir_sederhana;

public interface KelolaStok {
    void tambahStok(Produk produk, int jumlah);
    void kurangiStok(Produk produk, int jumlah);
}
