package com.juegoscartas.juegocartas.Controllador;

import com.juegoscartas.juegocartas.Modelo.Carta;
import com.juegoscartas.juegocartas.Modelo.JuegoMemorama;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.animation.PauseTransition;

public class MemoramaControlador {

    @FXML
    private GridPane gridCartas;

    private JuegoMemorama juegoMemorama;
    private Carta primeraSeleccionada = null;

    public void iniciarJuego(int gridSize) {
        int parejas = (gridSize * gridSize) / 2;
        juegoMemorama = new JuegoMemorama(parejas);
        mostrarCartas(gridSize);
    }

    private void mostrarCartas(int gridSize) {
        gridCartas.getChildren().clear();
        int index = 0;
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                if (index >= juegoMemorama.getCartas().size()) break;
                Carta carta = juegoMemorama.getCartas().get(index++);
                Button botonCarta = crearBotonCarta(carta);
                gridCartas.add(botonCarta, col, row);
            }
        }
    }

    private Button crearBotonCarta(Carta carta) {
        Button boton = new Button();
        boton.setPrefSize(100, 100);

        Image reverso = new Image("/com/juegoscartas/juegocartas/asest/reverso.jpg");
        ImageView imageView = new ImageView(reverso);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        boton.setGraphic(imageView);

        boton.setOnAction(e -> manejarClickCarta(carta, boton));
        return boton;
    }

    private void manejarClickCarta(Carta carta, Button boton) {
        if (carta.isVisible() || (primeraSeleccionada != null && primeraSeleccionada.equals(carta))) return;

        carta.setVisible(true);
        Image imagenCarta = new Image(carta.getImagePath());
        ImageView imageView = new ImageView(imagenCarta);
        imageView.setFitWidth(80);
        imageView.setFitHeight(80);
        boton.setGraphic(imageView);

        if (primeraSeleccionada == null) {

            primeraSeleccionada = carta;
        } else {

            Carta segundaSeleccionada = carta;

            if (juegoMemorama.sonPareja(primeraSeleccionada, segundaSeleccionada)) {

                primeraSeleccionada = null;
            } else {

                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(event -> {

                    primeraSeleccionada.setVisible(false);
                    Image reverso = new Image("/com/juegoscartas/juegocartas/asest/reverso.jpg");
                    ImageView reversoView1 = new ImageView(reverso);
                    reversoView1.setFitWidth(80);
                    reversoView1.setFitHeight(80);
                    Button botonPrimera = (Button) gridCartas.getChildren().get(juegoMemorama.getCartas().indexOf(primeraSeleccionada));
                    botonPrimera.setGraphic(reversoView1);


                    segundaSeleccionada.setVisible(false);
                    ImageView reversoView2 = new ImageView(reverso);
                    reversoView2.setFitWidth(80);
                    reversoView2.setFitHeight(80);
                    boton.setGraphic(reversoView2);

                    primeraSeleccionada = null;
                });
                pause.play();
            }
        }
    }
}
