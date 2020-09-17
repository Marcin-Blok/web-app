package pl.marcinblok.webapp.model;

public class Doctor {


        private int id;
        private String name;
        private String surname;
        private String pesel;

        public Doctor() {
        }

        public Doctor(String name, String surname,String pesel){
            this.name = name;
            this.surname = surname;
            this.pesel = pesel;
        }
}
