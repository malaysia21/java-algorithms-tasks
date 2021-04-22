package task.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepth {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeftChild(new Node(2));
        root.setRightChild(new Node(3));
        root.getRightChild().setRightChild(new Node(4));
        root.getLeftChild().setRightChild(new Node(5));
        root.getLeftChild().setLeftChild(new Node(6));
        root.getLeftChild().getRightChild().setRightChild(new Node(7));
        root.getRightChild().getRightChild().setRightChild(new Node(8));

        System.out.println(minimumDepth(root));
        System.out.println(minimumDepthRecurrenceSolution2(root));
        System.out.println(minimumDepthQueue(root));

    }


    private static int minimumDepth(Node node) {
        int minDepth = Integer.MAX_VALUE;

        if (node != null) {
            int currentDepth = 1;
            int minDepthR = minimumDepthRecurrence(node.getRightChild(), currentDepth, minDepth);
            int minDepthL = minimumDepthRecurrence(node.getLeftChild(), currentDepth, minDepth);
            return Math.min(minDepthR, minDepthL);
        }

        return 0;
    }

    //DFS
    private static int minimumDepthRecurrence(Node node, int currentDepth, int minDepth) {
        if(node!= null) {
            currentDepth++;

            if (node.getLeftChild() != null) {
                minDepth = minimumDepthRecurrence(node.getLeftChild(), currentDepth, minDepth);
            }

            if (node.getRightChild() != null) {
                minDepth = minimumDepthRecurrence(node.getRightChild(), currentDepth, minDepth);
            }

            if (node.getRightChild() == null && node.getLeftChild() == null) {
                return Math.min(minDepth, currentDepth);
            }
        }
        return minDepth;
    }

    //DFS
    private static int minimumDepthRecurrenceSolution2(Node root) {
        if (root == null)
            return 0;

        if (root.getLeftChild() == null && root.getRightChild() == null)
            return 1;

        if (root.getLeftChild() == null)
            return minimumDepthRecurrenceSolution2(root.getRightChild()) + 1;

        if (root.getRightChild() == null)
            return minimumDepthRecurrenceSolution2(root.getLeftChild()) + 1;

        return Math.min(minimumDepthRecurrenceSolution2(root.getLeftChild()),
                minimumDepthRecurrenceSolution2(root.getRightChild())) + 1;
    }

    //BFS
    private static int minimumDepthQueue(Node root) {
        if (root == null) {
            return 0;
        }

        Queue<QueueItem> nodeQueue = new LinkedList<>();
        QueueItem queueItem = new QueueItem(root, 1);
        nodeQueue.add(queueItem);

        while (!nodeQueue.isEmpty()) {

            queueItem = nodeQueue.peek();
            nodeQueue.remove();

            Node node = queueItem.getNode();
            int depth = queueItem.getDepth();

            if (node.getLeftChild() == null && node.getRightChild() == null) {
                return depth;
            }

            if (node.getLeftChild() != null)
            {
                QueueItem queueItemLeft = new QueueItem(node.getLeftChild(), depth + 1);
                nodeQueue.add(queueItemLeft);
            }

            if (node.getRightChild() != null)
            {
                QueueItem queueItemRight= new QueueItem(node.getRightChild(), depth + 1);
                nodeQueue.add(queueItemRight);
            }
        }

        return 0;
    }

}
