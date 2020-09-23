package pl.marcinblok.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import pl.marcinblok.webapp.DoctorList;

@Controller
public class DoctorsController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/doctors")
    public String allDoctors(Model model) {
        DoctorList doctors = restTemplate.getForObject("http://localhost:1234/doctors", DoctorList.class);
        model.addAttribute("doctors", doctors.getDoctors());
        return "doctors";
    }
}