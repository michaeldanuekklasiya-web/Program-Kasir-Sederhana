package com.example.program_kasir_sederhana;

import javafx.collections.ObservableList;

public class Transaksi implements Transaksii{
    private Produk produk;
    private int jumlah;
    private double total;

    public Transaksi(Produk produk, int jumlah) {
        this.produk = produk;
        this.jumlah = jumlah;
        this.total = total;
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

    @Override
    public String getNamaProduk() {
        return null;
    }

    @Override
    public int getJumlahBarang() {
        return 0;
    }

    @Override
    public double getTotalBayar() {
        return 0;
    }

    @Override
    public ObservableList<Transaksi> getHistoryData() {
        return null;
    }

    @Override
    public void prosesTransaksi(Transaksi transaksi) {

    }
}
