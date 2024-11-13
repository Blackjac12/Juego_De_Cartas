package com.juegoscartas.juegocartas.Modelo;

public class Carta {
    private final int id;
    private final String imagePath;
    private boolean visible = false;

    public Carta(int id, String imagePath) {
        this.id = id;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public String getImagePath() {
        return imagePath;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
