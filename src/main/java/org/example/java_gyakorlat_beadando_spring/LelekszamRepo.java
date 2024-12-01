package org.example.java_gyakorlat_beadando_spring;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LelekszamRepo extends CrudRepository<Lelekszam, Integer> {


    @Query("SELECT AVG(l.osszesen) FROM Lelekszam l WHERE l.varosid = :varosid GROUP BY l.varosid")
    String getAveragePopulationPerCity(@Param("varosid") int varosid);

    @Query("SELECT AVG(l.no) FROM Lelekszam l WHERE l.varosid = :varosid GROUP BY l.varosid")
    String getAverageWomenPerCity(@Param("varosid") int varosid);

}