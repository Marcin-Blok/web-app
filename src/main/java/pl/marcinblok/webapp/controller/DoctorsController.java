package pl.marcinblok.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import pl.marcinblok.webapp.model.Doctor;

import java.util.List;

@Controller
public class DoctorsController {

    private static final Logger log = LoggerFactory.getLogger(DoctorsController.class);

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

    @GetMapping("/addDoctor")
    public String addDoctor() {
        return "addDoctor";
    }

//    @PostMapping("/addDoctor")
//    public String addDoctorPost(@ModelAttribute("doctor") Doctor doctor) {
//        List<Specialization> specializations = new ArrayList<>();
//        specializations.add(new Specialization(specialization));
//        HttpEntity<Doctor> request = new HttpEntity<>(new Doctor(name, surname, pnumber, specializations));
//        Doctor doctor = restTemplate.postForObject("http://localhost:8080/doctors", request, Doctor.class);
//
//        return "redirect:doctors";
//    }

    @PostMapping("/addDoctor")
    public String addDoctorPost(@ModelAttribute("doctor")Doctor doctor) {

        log.info("zapisuję doktora: "+doctor.toString());


        ResponseEntity<Doctor> response = restTemplate.exchange(
                "http://localhost:8080/doctors", HttpMethod.POST, new HttpEntity<>(doctor), Doctor.class);

        if(response.getStatusCode() != HttpStatus.OK){
            // zostań na stronie i wyświetl co poszło nie tak.
            log.info(response.getStatusCode().toString());
        }

        return "redirect:doctors";

    }

}
