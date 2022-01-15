package smirnov.artur.volta.ts.it.tree;

public class Node {
    private Node father = null;
    private Node nextBrother = null;
    private Node nextSun = null;

    private String val = null;
    private Long size;
    private Long nFiles;
    private String files;

    public Node (Node father, String val, Long size, Long nFiles) {
        this.father = father;
        this.val = val;
        this.size = size;
        this.nFiles = nFiles;
        
        files = "";
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
    
    public void addFilesInDir (String s) {
    	files = getFiles() + s;
    }
    
    public Node getFather () {
    	return father;
    }
    
    public Node getNextBrother () {
    	return nextBrother;
    }
    
    public Node getNextSun () {
    	return nextSun;
    }

	public String getVal() {
		return val;
	}

	public long getSize() {
		return size;
	}

	public Long getnFiles() {
		return nFiles;
	}

	public String getFiles() {
		return files;
	}
}