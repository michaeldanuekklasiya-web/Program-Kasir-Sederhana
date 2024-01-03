package com.example.program_kasir_sederhana;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class ProdukUI extends VBox {
    private Label nameLabel;
    private Label priceLabel;
    private Label stockLabel;

    public ProdukUI(Produk produk) {
        this.nameLabel = new Label("Nama: " + produk.getNama());
        this.priceLabel = new Label("Harga: " + produk.getHarga());
        this.stockLabel = new Label("Stok: " + produk.getStok());

        this.getChildren().addAll(nameLabel, priceLabel, stockLabel);
        this.setSpacing(10);
    }
}
