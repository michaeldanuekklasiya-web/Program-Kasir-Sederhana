package com.example.pemilihan_ketua_organisasi;

public interface KelolaStok {
    void tambahStok(Produk produk, int jumlah);
    void kurangiStok(Produk produk, int jumlah);
}
