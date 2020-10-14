package pl.marcinblok.webapp.model;

import java.util.List;
import java.util.Set;

public class Doctor {
    private int id;
    private String name;
    private String surname;
    private String pesel;
    private List<Day> days;
    private Set<Specialization> specializations;


    public Doctor() {
    }

    public Doctor(String name, String surname, String pesel, Set<Specialization> specializations) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.specializations = specializations;
    }
}
