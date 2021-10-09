import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Node {
    private File folder;
    private ArrayList<Node> children;
    private static char[] sizeMultipliers = {'B', 'K', 'M', 'G', 'T'};
    private int level = 0;

    private long size;

    public Node(File folder){
        this.folder = folder;
        children = new ArrayList<>();
    }

    public File getFolder(){
        return folder;
    }
    public void addChild(Node node){
        node.setLevel(level + 1);
        children.add(node);

    }

    private void setLevel(int level) {
        this.level = level;
    }

    public ArrayList<Node> getChildren(){
        return children;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String toString(){
        //String size = SizeCalculator.getHumanReadableSize(getSize());
        StringBuilder builder = new StringBuilder();
        String size = SizeCalculator.getHumanReadableSize(getSize());
        builder.append(folder.getName() + " - " + size + "\n");
        for (Node child : children){
            builder.append("  " + child.toString());
        }
        return builder.toString();
    }

}

