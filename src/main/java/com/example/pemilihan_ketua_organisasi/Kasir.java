package com.example.pemilihan_ketua_organisasi;
import java.util.ArrayList;
import java.util.List;

public class Kasir {
    private List<Transaksi> daftarTransaksi;

    public Kasir() {
        this.daftarTransaksi = new ArrayList<>();
    }

    public void prosesTransaksi(Transaksi transaksi) {
        daftarTransaksi.add(transaksi);
        // Tambahan logika kasir sesuai kebutuhan
    }

    public double hitungTotalBelanja() {
        double total = 0;
        for (Transaksi transaksi : daftarTransaksi) {
            total += transaksi.hitungTotal();
        }
        return total;
    }
}