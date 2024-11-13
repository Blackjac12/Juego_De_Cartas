package com.juegoscartas.juegocartas.Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JuegoMemorama {
    private List<Carta> cartas;
    private Carta cartaSeleccionada1 = null;
    private Carta cartaSeleccionada2 = null;

    public JuegoMemorama(int parejas) {
        cartas = crearCartas(parejas);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    private List<Carta> crearCartas(int parejas) {
        List<Carta> cartas = new ArrayList<>();
        List<String> imagePaths = List.of(
                "/com/juegoscartas/juegocartas/asest/10_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/10_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/10_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/10_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/2_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/2_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/2_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/2_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/5_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/5_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/5_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/5_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/2_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/6_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/6_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/6_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/6_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/7_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/7_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/7_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/7_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/8_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/8_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/8_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/8_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/9_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/9_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/9_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/9_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/ace_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/ace_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/ace_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/ace_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/ace_of_spades2.jpg",
                "/com/juegoscartas/juegocartas/asest/jack_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/jack_of_clubs2.jpg",
                "/com/juegoscartas/juegocartas/asest/jack_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/jack_of_diamonds2.jpg",
                "/com/juegoscartas/juegocartas/asest/jack_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/jack_of_hearts2.jpg",
                "/com/juegoscartas/juegocartas/asest/jack_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/jack_of_spades2.jpg",
                "/com/juegoscartas/juegocartas/asest/king_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/king_of_clubs2.jpg",
                "/com/juegoscartas/juegocartas/asest/king_of_diamonds.jpg",
                "/com/juegoscartas/juegocartas/asest/king_of_diamonds2.jpg",
                "/com/juegoscartas/juegocartas/asest/king_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/king_of_hearts2.jpg",
                "/com/juegoscartas/juegocartas/asest/king_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/king_of_spades2.jpg",
                "/com/juegoscartas/juegocartas/asest/queen_of_clubs.jpg",
                "/com/juegoscartas/juegocartas/asest/queen_of_clubs2.jpg",
                "/com/juegoscartas/juegocartas/asest/queen_of_diamonds2.jpg",
                "/com/juegoscartas/juegocartas/asest/queen_of_hearts.jpg",
                "/com/juegoscartas/juegocartas/asest/queen_of_hearts2.jpg",
                "/com/juegoscartas/juegocartas/asest/queen_of_spades.jpg",
                "/com/juegoscartas/juegocartas/asest/queen_of_spades2.jpg"
        );

        for (int i = 0; i < parejas; i++) {
            String imagePath = imagePaths.get(i % imagePaths.size());
            cartas.add(new Carta(i, imagePath));
            cartas.add(new Carta(i, imagePath));
        }
        Collections.shuffle(cartas);
        return cartas;
    }

    public boolean seleccionarCarta(Carta carta) {
        if (cartaSeleccionada1 == null) {
            cartaSeleccionada1 = carta;
            carta.setVisible(true);
            return false;
        } else if (cartaSeleccionada2 == null && carta != cartaSeleccionada1) {
            cartaSeleccionada2 = carta;
            carta.setVisible(true);
            if (cartaSeleccionada1.getId() == cartaSeleccionada2.getId()) {
                cartaSeleccionada1 = null;
                cartaSeleccionada2 = null;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void resetearSeleccion() {
        if (cartaSeleccionada1 != null) cartaSeleccionada1.setVisible(false);
        if (cartaSeleccionada2 != null) cartaSeleccionada2.setVisible(false);
        cartaSeleccionada1 = null;
        cartaSeleccionada2 = null;
    }

    public boolean sonPareja(Carta carta1, Carta carta2) {
        
        return carta1.getId() == carta2.getId();
    }
}
