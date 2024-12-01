package org.example.java_gyakorlat_beadando_spring;

public class VarotNotFound extends RuntimeException {
    public VarotNotFound(int id) {
        super("A város nem található: " + id);
    }
}

