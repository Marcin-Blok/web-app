package pl.marcinblok.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.marcinblok.webapp.model.Doctor;

import java.util.List;

@Controller
public class DoctorsController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/doctors")
    public String allDoctors(Model model) {
        List<Doctor> doctors = (List<Doctor>) restTemplate.getForObject("http://localhost:8080/doctors", Doctor.class);
        model.addAttribute("doctors", doctors);
        return "doctors";
    }
}