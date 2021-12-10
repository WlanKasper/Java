package WlanKasper.com.TreeStruct;

import WlanKasper.com.TreeStruct.Node.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Main {

    static final String DIR = "/Users/arthursmirnov/Documents";
    private static FileWriter log;

    public static void main (String[] args) throws IOException {

        Node node = new Node(null, DIR);
        File folder = new File(DIR);
        log = new FileWriter("/Users/arthursmirnov/Documents/Java/WorkSpace_IN/TreeStruct/src/WlanKasper/com/TreeStruct/log.txt");

        scanDir(node, folder, "");
        log.write("\n" + "------------------------");

        showTree(node, "");
    }

    public static void scanDir (Node node, File folder, String indent) throws IOException {
        for (File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
                log.write("\n" + indent + "_D_" + fileEntry.getName());

                Node newNode = new Node(node, fileEntry.getName());
                node.addNewNode(newNode);

                scanDir(newNode, fileEntry, indent + "----");
            } else {
                log.write("\n" + indent + "--------" + fileEntry.getName());
            }
        }
    }

    public static void showTree (Node node, String indent) throws IOException {
        while (node != null){
            log.write("\n" + indent + node.name);
            showTree(node.nextSun, indent + "----");
            node = node.nextBrother;
        }
    }
}
