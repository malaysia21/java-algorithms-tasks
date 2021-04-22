package task.binarytree;

public class QueueItem {
    private Node node;
    private int depth;

    public QueueItem(Node node, int depth) {
        this.node = node;
        this.depth = depth;
    }

    public Node getNode() {
        return node;
    }

    public int getDepth() {
        return depth;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
