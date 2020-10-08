package pl.marcinblok.webapp.model;

import java.util.List;

public class Doctor {


    private int id;
    private String name;
    private String surname;
    private String pesel;
    private List<Specialization> specialization;

    public Doctor() {
    }


    public Doctor(String name, String surname, String pesel, List<Specialization> specialization) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.specialization = specialization;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public List<Specialization> getSpecialization() {
        return specialization;
    }

    public void setSpecialization(List<Specialization> specialization) {
        this.specialization = specialization;
    }
}
