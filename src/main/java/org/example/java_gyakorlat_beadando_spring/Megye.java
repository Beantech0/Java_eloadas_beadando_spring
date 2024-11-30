package org.example.java_gyakorlat_beadando_spring;

import jakarta.persistence.*;

@Entity
@Table(name = "megye")
public class Megye {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String nev;
}
