package com.example.pemilihan_ketua_organisasi;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class BelanjaUI extends VBox {
    private Kasir kasir;
    private TextField jumlahUangField;
    private Label kembalianLabel;

    public BelanjaUI(Kasir kasir) {
        this.kasir = kasir;
        this.jumlahUangField = new TextField();
        this.kembalianLabel = new Label("Kembalian: ");

        Button tombolSelesai = new Button("Selesai");

        tombolSelesai.setOnAction(e -> {
            double totalBelanja = kasir.hitungTotalBelanja();
            double jumlahUang = Double.parseDouble(jumlahUangField.getText());
            double kembalian = jumlahUang - totalBelanja;
            kembalianLabel.setText("Kembalian: " + kembalian);
        });

        setAlignment(Pos.CENTER);
        setPadding(new Insets(20));
        setSpacing(10);
        getChildren().addAll(new Label("Jumlah Uang:"), jumlahUangField, kembalianLabel, tombolSelesai);
    }
}

