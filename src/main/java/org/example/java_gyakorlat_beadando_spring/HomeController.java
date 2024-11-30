package org.example.java_gyakorlat_beadando_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @Autowired private LelekszamRepo lelekszamRepo;
    @Autowired private MegyeRepo megyeRepo;
    @Autowired private VarosRepo varosRepo;
}
