package pl.marcinblok.webapp.model;

public class Day {
    private int id;
    private DayOfWeek day;
    private DoctorRequest doctor;

    public Day() {
    }

    public Day(DayOfWeek day) {
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DayOfWeek getDay() {
        return day;
    }

    public void setDay(DayOfWeek day) {
        this.day = day;
    }

    public DoctorRequest getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorRequest doctor) {
        this.doctor = doctor;
    }
}
