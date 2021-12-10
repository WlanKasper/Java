package WlanKasper.com.Person_List.src;

import java.util.Locale;

public class PersonList {

    private final Person firstPerson;

    public PersonList() {
        firstPerson = new Person();  // HEAD (link)
    }

    public void addNewPerson(Person person) {
        if (firstPerson.getNextPerson() == null) {  // Если это первый элемент в списке
            firstPerson.setNextPerson(person);
        } else {                                    // Если это второй элемент в списке
            newSortedPerson(person);
        }
    }

    public void newSortedPerson(Person person) {
        Person temp = firstPerson.getNextPerson();  // Элемент с которым сравниваем
        Person hash = firstPerson;                  // Элемент перед temp, с которым сравниваем

        int action = 0;
                                                    /*
                                                       1 - person > temp
                                                       0 - person == temp
                                                      -1 - person < temp
                                                    */

        do {
            if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) == 0) {
                action = 0;
            }
            if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) > 0) {
                action = 1;
            }
            if (person.getPersonLastname().toLowerCase(Locale.ROOT).compareTo(temp.getPersonLastname().toLowerCase(Locale.ROOT)) < 0) {
                action = -1;
            }
            switch (action) {

                case 1:
                    temp = temp.getNextPerson();
                    hash = hash.getNextPerson();
                    continue;
                case 0:
                    do {
                        if (person.getPersonName().toLowerCase(Locale.ROOT).compareTo(temp.getPersonName().toLowerCase(Locale.ROOT)) == 0) {
                            action = 0;
                        }
                        if (person.getPersonName().toLowerCase(Locale.ROOT).compareTo(temp.getPersonName().toLowerCase(Locale.ROOT)) > 0) {
                            action = 1;
                        }
                        if (person.getPersonName().toLowerCase(Locale.ROOT).compareTo(temp.getPersonName().toLowerCase(Locale.ROOT)) < 0) {
                            action = -1;
                        }
                        switch (action) {
                            case 1:
                                temp = temp.getNextPerson();
                                hash = hash.getNextPerson();
                                continue;
                            case 0:
                                person.setNextPerson(temp.getNextPerson());
                                temp.setNextPerson(person);
                                return;
                            case -1:
                                person.setNextPerson(temp);
                                hash.setNextPerson(person);
                                return;
                        }
                    } while (hash.getNextPerson() != null);

                    hash.setNextPerson(person);

                    return;
                case -1:
                    person.setNextPerson(temp);
                    hash.setNextPerson(person);
                    return;
            }
        } while (hash.getNextPerson() != null);

        hash.setNextPerson(person);                 // Если не сработает return;

    }

    public String getPersonList() {
        Person temp = firstPerson;
        StringBuilder str = new StringBuilder();

        while (temp.getNextPerson() != null) {
            temp = temp.getNextPerson();
            if (!temp.getPersonLastname().equals("") && !temp.getPersonName().equals("")) {
                str.append(temp.toString());
            }
        }
        return str.toString();
    }
}