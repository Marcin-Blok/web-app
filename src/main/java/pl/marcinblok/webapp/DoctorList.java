package pl.marcinblok.webapp;

import pl.marcinblok.webapp.model.DoctorRequest;

import java.util.List;

public class DoctorList {


    private List<DoctorRequest> doctors;

    public DoctorList(List<DoctorRequest> doctors) {
        this.doctors = doctors;
    }

    public List<DoctorRequest> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<DoctorRequest> doctors) {
        this.doctors = doctors;
    }
}
