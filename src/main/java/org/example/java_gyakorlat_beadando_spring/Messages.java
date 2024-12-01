package org.example.java_gyakorlat_beadando_spring;


import jakarta.persistence.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.time.LocalDateTime;

@Entity
@Table(name="messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getFelhasznalo() {
        return felhasznalo;
    }

    public void setFelhasznalo(String felhasznalo) {
        this.felhasznalo = felhasznalo;
    }

    @Column(name = "felhasznalo")
    private String felhasznalo;

    @Column(name = "szoveg")
    private String szoveg;


    @Column(name = "datum")
    @Order(Ordered.HIGHEST_PRECEDENCE)
    private LocalDateTime datum;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSzoveg() {
        return szoveg;
    }

    public void setSzoveg(String szoveg) {
        this.szoveg = szoveg;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }
}
