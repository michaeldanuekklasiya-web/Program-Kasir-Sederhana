package com.example.program_kasir_sederhana;
import java.util.ArrayList;
import java.util.List;

public class Kasir {
    private List<Transaksi> daftarTransaksi;

    public Kasir() {
        this.daftarTransaksi = new ArrayList<>();
    }

    public void prosesTransaksi(Transaksi transaksi) {
        daftarTransaksi.add(transaksi);
    }

    public double hitungTotalBelanja() {
        double total = 0;
        for (Transaksi transaksi : daftarTransaksi) {
            total += transaksi.hitungTotal();
        }
        return total;
    }
}