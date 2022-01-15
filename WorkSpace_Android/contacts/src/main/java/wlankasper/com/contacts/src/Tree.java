package wlankasper.com.contacts.src;

public class Tree {
    int number;
    String nameSurname;
    Tree father;

    public Tree (int number, String nameSurname, Tree father) {
        this.number = number;
        this.nameSurname = nameSurname;
        this.father = father;
    }
}
