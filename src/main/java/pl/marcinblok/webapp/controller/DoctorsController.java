package pl.marcinblok.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.marcinblok.webapp.model.Doctor;

import java.util.ArrayList;
import java.util.List;

@Controller
public class DoctorsController {

    @GetMapping("/doctors")
    public String allDoctors(Model model) {
        List<Doctor> doctors = new ArrayList<>();
        doctors.add(new Doctor("Piotr", "Wierzbicki", "78051645372"));
        doctors.add(new Doctor("Jerzy", "Kiler", "66112878132"));
        doctors.add(new Doctor("Andrzej", "Makowiecki", "83041283273"));
        model.addAttribute("doctors", doctors);
        return "doctors";
    }
}
