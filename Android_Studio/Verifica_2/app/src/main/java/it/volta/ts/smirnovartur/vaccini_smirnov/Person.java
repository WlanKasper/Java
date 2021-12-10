package it.volta.ts.smirnovartur.vaccini_smirnov;

public class Person {


    private String name;
    private String lastname;
    private String typeVaccine;
    private String doneVaccine = "NO";




    public Person(String name, String lastname, String typeVaccine) {
        this.name = name;
        this.lastname = lastname;
        this.typeVaccine = typeVaccine;
    }

    @Override
    public String toString() {
        return "\n Name: " + name + " Lastname: " + lastname + " | Preferred Vaccine: " + typeVaccine + " DONE Vaccine: " + doneVaccine;
    }

    public String getDoneVaccine() {
        return doneVaccine;
    }

    public void setDoneVaccine(String doneVaccine) {
        this.doneVaccine = doneVaccine;
    }
    public String getTypeVaccine() {
        return typeVaccine;
    }

    public void setTypeVaccine(String typeVaccine) {
        this.typeVaccine = typeVaccine;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
