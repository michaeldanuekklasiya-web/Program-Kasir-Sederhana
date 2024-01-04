package com.example.program_kasir_sederhana;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Inventaris {
    private ObservableList<Produk> daftarProduk;

    public Inventaris() {
        this.daftarProduk = FXCollections.observableArrayList();
    }

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public ObservableList<Produk> getDaftarProduk() {
        return daftarProduk;
    }
}