package pl.marcinblok.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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
        ResponseEntity<List<Doctor>> doctorResponse =
                restTemplate.exchange("http://localhost:8080/doctors",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Doctor>>() {
                        });
        List<Doctor> doctors = doctorResponse.getBody();
        model.addAttribute("doctors", doctors);
        return "doctors";
    }
}
