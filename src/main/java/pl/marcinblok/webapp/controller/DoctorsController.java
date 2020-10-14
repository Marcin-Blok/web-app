package pl.marcinblok.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import pl.marcinblok.webapp.model.Doctor;
import pl.marcinblok.webapp.model.DoctorRequest;
import pl.marcinblok.webapp.model.Specialization;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class DoctorsController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/doctors")
    public String allDoctors(Model model) {
        ResponseEntity<List<DoctorRequest>> doctorResponse =
                restTemplate.exchange("http://localhost:8080/doctors",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<DoctorRequest>>() {
                        });
        List<DoctorRequest> doctors = doctorResponse.getBody();
        model.addAttribute("doctors", doctors);
        return "doctors";
    }

    @GetMapping("/addDoctor")
    public String addDoctor() {
        return "addDoctor";
    }


    @PostMapping("/addDoctor")
    public String addDoctorPost(@ModelAttribute("doctor") DoctorRequest doctorRequest) {
        String name = doctorRequest.getName();
        String surname = doctorRequest.getSurname();
        String pesel = doctorRequest.getPesel();
        String specialization = doctorRequest.getSpecialization();

        Set<Specialization> specializations = new HashSet<>();
        specializations.add(new Specialization(specialization));

        Doctor doctor = new Doctor(name, surname, pesel, specializations);
        HttpEntity<Doctor> requestToService = new HttpEntity<>(doctor);
        restTemplate.postForObject("http://localhost:8080/doctors", requestToService, Doctor.class);
        return "redirect:doctors";
    }

}
