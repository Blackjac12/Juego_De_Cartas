module com.juegoscartas.juegocartas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.juegoscartas.juegocartas to javafx.fxml;
    exports com.juegoscartas.juegocartas;

    exports com.juegoscartas.juegocartas.Controllador to javafx.fxml;
    opens com.juegoscartas.juegocartas.Vista to javafx.fxml;
    opens com.juegoscartas.juegocartas.Controllador to javafx.base, javafx.fxml;
}