package WlanKasper.com.TreeStruct.Node;

public class Node {
    public Node father = null;
    public Node nextBrother = null;
    public Node nextSun = null;

    public String name = null;

    public Node (Node father, String name) {
        this.father = father;
        this.name = name;
    }

    public void addNewNode (Node node){
        if (nextSun == null) {
            nextSun = node;
        } else {
            Node tail = nextSun;
            Node temp = nextSun.nextBrother;
            while (temp != null) {
                tail = temp;
                temp = temp.nextBrother;
            }
            tail.nextBrother = node;
        }
    }
}
