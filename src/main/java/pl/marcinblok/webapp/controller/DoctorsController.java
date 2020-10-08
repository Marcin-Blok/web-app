package pl.marcinblok.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import pl.marcinblok.webapp.model.Doctor;

import javax.validation.Valid;
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

    @RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
    public String addDoctorPost(@Valid @ModelAttribute("doctor")Doctor doctor,
                         BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "Błąd zapisu!";
        }
        model.addAttribute("name", doctor.getName());
        model.addAttribute("surname", doctor.getSurname());
        model.addAttribute("pesel", doctor.getPesel());
        model.addAttribute("specialization", doctor.getSpecialization());
        return "doctor";
    }

}
