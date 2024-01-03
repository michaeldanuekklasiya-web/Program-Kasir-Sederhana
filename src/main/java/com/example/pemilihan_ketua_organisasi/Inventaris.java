package com.example.pemilihan_ketua_organisasi;
import java.util.ArrayList;
import java.util.List;

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
