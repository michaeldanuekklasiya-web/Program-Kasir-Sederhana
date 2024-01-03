module com.example.pemilihan_ketua_organisasi {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pemilihan_ketua_organisasi to javafx.fxml;
    exports com.example.pemilihan_ketua_organisasi;
}