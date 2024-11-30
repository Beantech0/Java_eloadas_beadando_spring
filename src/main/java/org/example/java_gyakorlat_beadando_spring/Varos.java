package org.example.java_gyakorlat_beadando_spring;

import jakarta.persistence.*;

@Entity
@Table(name = "varos")
public class Varos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nev;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getMegyeid() {
        return megyeid;
    }

    public void setMegyeid(int megyeid) {
        this.megyeid = megyeid;
    }

    public boolean isMegyeszekhely() {
        return megyeszekhely;
    }

    public void setMegyeszekhely(boolean megyeszekhely) {
        this.megyeszekhely = megyeszekhely;
    }

    public boolean isMegyeijogu() {
        return megyeijogu;
    }

    public void setMegyeijogu(boolean megyeijogu) {
        this.megyeijogu = megyeijogu;
    }

    private int megyeid;
    private boolean megyeszekhely;
    private boolean megyeijogu;
}
