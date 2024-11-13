package com.juegoscartas.juegocartas.Controllador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import com.juegoscartas.juegocartas.Modelo.Carta;
import com.juegoscartas.juegocartas.Modelo.JuegoMemorama;

public class MemoramaControlador {

    @FXML
    private GridPane gridPane;

    private JuegoMemorama modelo;

    public void iniciarJuego(int gridSize) {
        modelo = new JuegoMemorama(gridSize * gridSize / 2);
        configurarTablero(gridSize);
    }

    private void configurarTablero(int size) {
        gridPane.getChildren().clear();

        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Carta carta = modelo.getCartas().get(index++);
                Button cartaBtn = crearBotonCarta(carta);
                gridPane.add(cartaBtn, j, i);
            }
        }
    }

    private Button crearBotonCarta(Carta carta) {
        Button cartaBtn = new Button();
        actualizarBotonCarta(carta, cartaBtn);

        cartaBtn.setOnAction(e -> {
            if (modelo.seleccionarCarta(carta)) {
                actualizarBotonCarta(carta, cartaBtn);
            } else {
                actualizarBotonCarta(carta, cartaBtn);
                new Thread(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    modelo.resetearSeleccion();
                    actualizarBotonCarta(carta, cartaBtn);
                }).start();
            }
        });

        return cartaBtn;
    }

    private void actualizarBotonCarta(Carta carta, Button cartaBtn) {
        if (carta.isVisible()) {
            cartaBtn.setText(String.valueOf(carta.getId()));
        } else {
            cartaBtn.setText("");
        }
    }
}
