package wlankasper.com.verifica_2.src;

import java.util.ArrayList;

public class PersonList {

    private ArrayList<Person> arrayList;

    public PersonList() {
        arrayList = new ArrayList<>();
    }

    public void addPerson(Person person) {
        arrayList.add(person);
    }

    public void deletePerson (Person person){
        arrayList.remove(person);
    }

    public Person getFirst (){
        return arrayList.get(0);
    }

    public ArrayList<Person> getArrayList() {
        return arrayList;
    }



    @Override
    public String toString() {
        String str = "";
        for (Person person : arrayList) {
            str += "/n " + person.toString();
        }
        return str;
    }

}

