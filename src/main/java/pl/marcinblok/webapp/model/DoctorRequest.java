package pl.marcinblok.webapp.model;

public class DoctorRequest {


    private int id;
    private String name;
    private String surname;
    private String pesel;
    private String specialization;

    public DoctorRequest() {
    }


    public DoctorRequest(String name, String surname, String pesel, String specialization) {
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
