package com.example.pemilihan_ketua_organisasi;

public class Transaksi {
    private Produk produk;
    private int jumlah;

    public Transaksi(Produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
    }

    public Produk getProduk() {
        return produk;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double hitungTotal() {
        return produk.getHarga() * jumlah;
    }
}
