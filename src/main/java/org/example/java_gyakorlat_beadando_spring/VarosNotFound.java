package org.example.java_gyakorlat_beadando_spring;

public class VarosNotFound extends RuntimeException {
    public VarosNotFound(int id) {
        super("A város nem található: " + id);
    }
}

