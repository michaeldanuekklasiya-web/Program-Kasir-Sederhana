module com.example.pemilihan_ketua_organisasi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.program_kasir_sederhana to javafx.fxml;
    exports com.example.program_kasir_sederhana;
}