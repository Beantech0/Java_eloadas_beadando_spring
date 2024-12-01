package org.example.java_gyakorlat_beadando_spring;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private MessagesRepo messagesRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
    @Autowired private VarosRepo varosRepo;
    @Autowired private LelekszamRepo lelekszamRepo;
    @Autowired private MegyeRepo megyeRepo;


    @GetMapping("/registration")
    public String greetingForm(Model model) {
        model.addAttribute("reg", new Users());
        return "registration";
    }
    @GetMapping("/home")
    public String WelcomeSite() {
        return "home";
    }

    @Autowired
    private UsersRepo usersRepo;
    @PostMapping("/registration_validation")
    public String Regisztráció(@ModelAttribute Users user, Model model) {
        for(Users newUser: usersRepo.findAll())
            if(newUser.getEmail().equals(user.getEmail())){
                model.addAttribute("uzenet", "Az email már foglalt!");
                return "registration_error";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("Guest");
        usersRepo.save(user);
        model.addAttribute("id", user.getId());
        return "registration_success";
    }

    @GetMapping("/varosok")
    public String Korlatok(Model model) {
        String str = VarosokData();
        model.addAttribute("str", str);
        return "varosok";
    }

    String VarosokData(){
//        List<Object[]> AveragePopulationPerCity = lelekszamRepo.getAveragePopulationPerCity();
        String str="";
        for(Varos varos_data: varosRepo.findAll()){
            str+="<tr>";
            str+="<td>" + varos_data.getNev() + "</td>";
            str+="<td>" + megyeRepo.findById(varos_data.getMegyeid()).get().getNev() + "</td>";
            str+="<td>" + varos_data.isMegyeszekhely() + "</td>";
            str+="<td>" + varos_data.isMegyeijogu() + "</td>";
            str+="<td>" + lelekszamRepo.getAveragePopulationPerCity(varos_data.getId()) + "</td>";
            str+="<td>" + lelekszamRepo.getAverageWomenPerCity(varos_data.getId()) + "</td>";
            str += "</tr>";
        }
        return str;
    }

    @GetMapping("/admin/uzenetek")
    public String AdminUzenetek(Model model) {
        String str = kapcsolatUzenet();
        model.addAttribute("str", str);
        return "kapcsolat_uzenetek";
    }
    String kapcsolatUzenet(){
        String str="";

        for(Messages egyediUzenet: messagesRepo.findAll()){
            str+="<tr>";

            str+="<td>" + egyediUzenet.getFelhasznalo() + "</td>";
            str+="<td>" + egyediUzenet.getDatum() + "</td>";
            str+="<td>" + egyediUzenet.getSzoveg() + "</td>";

            str+="</tr>";
        }
        return str;
    }
    @GetMapping("/kapcsolat")
    public String urlapForm(Model model) { // Model model: Dependency injection
        model.addAttribute("attr1", new Messages());
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat_success")
    // UzenetOsztaly uzenetOsztaly és Model model: Dependency injection
    public String urlapSubmit(@ModelAttribute Messages messageClass, Model model) {

        model.addAttribute("attr2", messageClass);

        LocalDateTime now = LocalDateTime.now();
        messageClass.setDatum(now);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();

        messageClass.setFelhasznalo(userName == "anonymousUser" ? "Vendég" : userName);


        if(!messageClass.getSzoveg().isEmpty())
        {
            messagesRepo.save(messageClass);
        }

        return "kapcsolat_success";
    }

}


