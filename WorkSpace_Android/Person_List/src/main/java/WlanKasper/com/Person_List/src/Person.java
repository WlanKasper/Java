package WlanKasper.com.Person_List.src;

public class Person {
    // Struct
    private String name, lastname;
    private Person nextPerson;

    public void setPersonData(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        this.nextPerson = null;
    }


    @Override
    public String toString() {
        return "\n" + lastname + " " + name;
    }

    public String getPersonLastname() {
        return lastname;
    }

    public String getPersonName() {
        return name;
    }

    public void setNextPerson(Person person) {
        this.nextPerson = person;
    }

    public Person getNextPerson() {
        return nextPerson;
    }

}

