package com.juegoscartas.juegocartas.Controllador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class MemoramaMenuControlador {

    @FXML
    private Button btn4x4;

    @FXML
    private Button btn6x6;

    @FXML
    private Button btn8x8;

    @FXML
    private Button btnSalir;

    @FXML
    public void initialize() {
        btn4x4.setOnAction(e -> iniciarJuego(4));
        btn6x6.setOnAction(e -> iniciarJuego(6));
        btn8x8.setOnAction(e -> iniciarJuego(8));
        btnSalir.setOnAction(e -> ((Stage) btnSalir.getScene().getWindow()).close());
    }

    private void iniciarJuego(int gridSize) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/juegoscartas/juegocartas/Vista/juego.fxml"));
            Parent root = loader.load();


            MemoramaControlador controladorJuego = loader.getController();
            controladorJuego.iniciarJuego(gridSize);

            Stage stage = (Stage) btn4x4.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
