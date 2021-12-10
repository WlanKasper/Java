package it.volta.ts.smirnovartur.vaccini_smirnov;

public class Box {
    private boolean isOccupied = false;
    String[] typeVaccine;

    public int getCounterVaccineted() {
        return counterVaccineted;
    }

    private int counterVaccineted = 0;

    public Box(String vaccine1,String vaccine2) {
        typeVaccine = new String[2];
        typeVaccine[0] = vaccine1;
        typeVaccine[1] = vaccine2;
    }

    public boolean controlTypeVaccine (Person person){
        if (person.getTypeVaccine().equals(typeVaccine[0]) || person.getTypeVaccine().equals(typeVaccine[1])){
            return true;
        }
        return false;
    }

    public void doVaccine(Person person){
        person.setDoneVaccine(person.getTypeVaccine());
        counterVaccineted++;
        isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
