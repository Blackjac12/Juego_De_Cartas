package com.juegoscartas.juegocartas.Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JuegoMemorama {
    private List<Carta> cartas;

    public JuegoMemorama(int parejas) {
        cartas = crearCartas(parejas);
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    private List<Carta> crearCartas(int parejas) {
        List<Carta> cartas = new ArrayList<>();
        List<String> imagePaths = List.of(
                // Profe las rutas son De mi pc si le le erro solo cambias el archivo C:\Users\vienn\OneDrive\Documentos\GitHub\ Donde lo tienes guardado
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\2_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\2_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\2_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\2_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\3_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\3_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\3_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\3_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\4_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\4_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\4_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\4_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\5_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\5_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\5_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\5_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\6_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\6_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\6_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\6_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\7_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\7_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\7_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\7_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\8_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\8_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\8_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\8_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\9_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\9_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\9_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\9_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\10_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\10_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\10_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\10_of_spades.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\ace_of_clubs.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\ace_of_diamonds.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\ace_of_hearts.jpg",
                "C:\\Users\\vienn\\OneDrive\\Documentos\\GitHub\\Juego_De_Cartas\\JuegoCartas\\src\\main\\java\\com\\juegoscartas\\juegocartas\\assets\\ace_of_spades.jpg"
        );




        for (int i = 0; i < parejas; i++) {
            String imagePath = imagePaths.get(i % imagePaths.size());
            cartas.add(new Carta(i, imagePath));
            cartas.add(new Carta(i, imagePath));
        }
        Collections.shuffle(cartas);
        return cartas;
    }

    public boolean sonPareja(Carta carta1, Carta carta2) {
        
        return carta1.getId() == carta2.getId();
    }
}
