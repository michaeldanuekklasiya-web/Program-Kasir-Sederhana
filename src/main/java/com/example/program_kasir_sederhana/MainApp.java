package com.example.program_kasir_sederhana;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class MainApp extends Application {

    private Stage primaryStage;
    private Scene mainScene;
    private Scene belanjaScene;

    private Inventaris inventaris;
    private Kasir kasir;

    private TableView<Transaksi> historyTable;
    private ObservableList<Transaksi> historyData;



    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        // Inisialisasi data inventaris
        inventaris = new Inventaris();
        inventaris.tambahProduk(new Produk("Kecap Bango", 10000, 50));
        inventaris.tambahProduk(new Produk("Bakso Sapi", 15000, 30));
        inventaris.tambahProduk(new Produk("Telur Asin", 5000, 30));
        inventaris.tambahProduk(new Produk("Tomat", 4000, 30));
        inventaris.tambahProduk(new Produk("Brokoli", 2000, 30));
        inventaris.tambahProduk(new Produk("Cabai", 20000, 30));

        // Inisialisasi kasir
        kasir = new Kasir();

        // Scene utama
        mainScene = buatMainScene();

        // Scene belanja
        belanjaScene = buatBelanjaScene();

        // Set awal scene ke mainScene
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Sistem Kasir Warung");
        primaryStage.show();
    }

    private Scene buatMainScene() {
        Label namaWarungLabel = new Label("Warung Michael");
        Button tombolMasuk = new Button("Masuk");

        tombolMasuk.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-weight: bold;");

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(namaWarungLabel, tombolMasuk);

        tombolMasuk.setOnAction(e -> primaryStage.setScene(belanjaScene));

        return new Scene(root, 300, 200);
    }



    private Scene buatBelanjaScene() {
        Label judulLabel = new Label("Hitung Belanjaan");
        ComboBox<Produk> produkComboBox = new ComboBox<>(inventaris.getDaftarProduk());
        TextField hargaSatuanField = new TextField();
        TextField jumlahField = new TextField();
        TextField totalBayarField = new TextField();
        TextField jumlahUangField = new TextField();
        TextField kembalianField = new TextField();
        kembalianField.setEditable(false);
        kembalianField.setVisible(false);

        Button tombolSelesai = new Button("Bayar");

        tombolSelesai.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-weight: bold;");

        judulLabel.setStyle("-fx-font-size: 18; -fx-font-weight: bold");

        tombolSelesai.setOnAction(e -> {
            Produk produk = produkComboBox.getValue();
            int jumlahBarang = Integer.parseInt(jumlahField.getText());

            double totalBayar = produk.getHarga() * jumlahBarang;
            totalBayarField.setText(String.valueOf(totalBayar));

            kasir.prosesTransaksi(new Transaksi(produk, jumlahBarang));

            double jumlahUang = Double.parseDouble(jumlahUangField.getText());
            double kembalian = jumlahUang - totalBayar;

            if (kembalian >= 0) {
                kembalianField.setText("Kembalian: " + kembalian);
            } else {
                kembalianField.setText("Uang Tidak Cukup");
            }

            kembalianField.setVisible(true);
        });

        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(judulLabel, produkComboBox, new Label("Harga Satuan:"), hargaSatuanField,
                new Label("Jumlah Barang:"), jumlahField,
                new Label("Total yang dibayar:"), totalBayarField,
                new Label("Jumlah Uang:"), jumlahUangField,
                new Label("Kembalian:"), kembalianField, tombolSelesai);

        hargaSatuanField.setEditable(false);

        produkComboBox.setOnAction(e -> {
            Produk produk = produkComboBox.getValue();
            hargaSatuanField.setText(String.valueOf(produk.getHarga()));
        });

        jumlahField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                int jumlahBarang = Integer.parseInt(newValue);
                double hargaSatuan = Double.parseDouble(hargaSatuanField.getText());
                double totalBayar = hargaSatuan * jumlahBarang;
                totalBayarField.setText(String.valueOf(totalBayar));
            } catch (NumberFormatException e) {
                totalBayarField.clear();
            }
        });

        return new Scene(root, 400, 300);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
