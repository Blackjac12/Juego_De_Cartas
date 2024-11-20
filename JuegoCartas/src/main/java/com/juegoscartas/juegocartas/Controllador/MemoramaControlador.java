package com.juegoscartas.juegocartas.Controllador;

import com.juegoscartas.juegocartas.Modelo.Carta;
import com.juegoscartas.juegocartas.Modelo.JuegoMemorama;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.animation.PauseTransition;

import java.util.HashMap;
import java.util.Map;

public class MemoramaControlador {
    private static final String RUTA_IMAGENES = "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\";
    @FXML
    private GridPane gridCartas;

    private JuegoMemorama juegoMemorama;
    private Carta primeraSeleccionada = null;
    private Map<Carta, Button> mapaCartasBotones;

    public void iniciarJuego(int gridSize) {
        int parejas = (gridSize * gridSize) / 2;
        juegoMemorama = new JuegoMemorama(parejas);
        mapaCartasBotones = new HashMap<>();
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
                mapaCartasBotones.put(carta, botonCarta);
                gridCartas.add(botonCarta, col, row);
            }
        }
    }

    private Button crearBotonCarta(Carta carta) {
        Button boton = new Button();
        boton.setPrefSize(100, 100);

        Image reverso = new Image(RUTA_IMAGENES + "reverso.jpg");
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

                if (juegoMemorama.esJuegoTerminado()) {
                    mostrarMensajeVictoria();
                }
            } else {
                PauseTransition pause = new PauseTransition(Duration.seconds(1));
                pause.setOnFinished(event -> {
                    primeraSeleccionada.setVisible(false);
                    segundaSeleccionada.setVisible(false);

                    Image reverso = new Image(RUTA_IMAGENES + "reverso.jpg");

                    Button botonPrimera = mapaCartasBotones.get(primeraSeleccionada);
                    Button botonSegunda = mapaCartasBotones.get(segundaSeleccionada);

                    ImageView reversoView1 = new ImageView(reverso);
                    reversoView1.setFitWidth(80);
                    reversoView1.setFitHeight(80);
                    botonPrimera.setGraphic(reversoView1);

                    ImageView reversoView2 = new ImageView(reverso);
                    reversoView2.setFitWidth(80);
                    reversoView2.setFitHeight(80);
                    botonSegunda.setGraphic(reversoView2);

                    primeraSeleccionada = null;
                });
                pause.play();
            }
        }
    }

    private void mostrarMensajeVictoria() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("¡Victoria!");
        alerta.setHeaderText(null);
        alerta.setContentText("¡Felicidades, has completado el juego!");
        alerta.showAndWait();
    }
}
