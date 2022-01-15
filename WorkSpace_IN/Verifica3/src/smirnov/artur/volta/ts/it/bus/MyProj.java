package smirnov.artur.volta.ts.it.bus;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

import smirnov.artur.volta.ts.it.layout.MyLayout;
import smirnov.artur.volta.ts.it.tree.Node;

public class MyProj {
	
	private static final String DIR = "../";
	MyLayout layout = null;
	
	public MyProj () {
		Node node = new Node(null, "root", 0L, 0L);
		File folder = new File(DIR);
		layout = new MyLayout();
		
		try {
			scanDir(node, folder, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writeTree(node, "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void scanDir (Node root, File folder, String indent) throws IOException {
        for (File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (fileEntry.isDirectory()) {
            	long[] arrTemp = getDirSize(new File(fileEntry.getAbsolutePath()));
                long size = arrTemp[0];
                long nf = arrTemp[1];
                
                Node newNode = new Node(root, fileEntry.getName(), size, nf);
                root.addNewNode(newNode);

                scanDir(newNode, fileEntry, indent + "----");
            } else if (fileEntry.isFile()) {
                root.addFilesInDir("\n" + indent + "--------" + fileEntry.getName());
            } else {
            	root.addFilesInDir("\n" + indent + "--------" + "?HIDDEN FILE?");
            }
        }
    }
	
	public long[] getDirSize (File dir) {
        long size = 0;
        long nf = 0;
        
        long[] arr = new long[2];
        
        if (dir.isFile()) {
            size = dir.length();
            nf++;
        } else {
            File[] subFiles = dir.listFiles();
            for (File file : subFiles) {
                if (file.isFile()) {
                    size += file.length();
                    nf++;
                } else {
                    long[] arrTemp = getDirSize(file);
                    size += arrTemp[0];
                    nf += arrTemp[1];
                }
                
            }
        }
        arr[0] += size;
        arr[1] += nf;
        return arr;
    }
	
	public void writeTree (Node node, String indent) throws IOException {
        while (node != null) {
        	layout.writeString("\n" + indent + " Dir | Name: " + node.getVal() + " | Size: " + node.getSize() + " byte | Files: " + node.getnFiles() + node.getFiles());
            writeTree(node.getNextSun(), indent + "----");
            node = node.getNextBrother();
        }
    }
}
