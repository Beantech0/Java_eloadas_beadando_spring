package org.example.java_gyakorlat_beadando_spring;

import jakarta.persistence.*;

@Entity
@Table(name = "lelekszam")
public class Lelekszam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int varosid;

    public int getOsszesen() {
        return osszesen;
    }

    public void setOsszesen(int osszesen) {
        this.osszesen = osszesen;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getEv() {
        return ev;
    }

    public void setEv(int ev) {
        this.ev = ev;
    }

    public int getVarosid() {
        return varosid;
    }

    public void setVarosid(int varosid) {
        this.varosid = varosid;
    }

    private int ev;
    private int no;
    private int osszesen;

}
