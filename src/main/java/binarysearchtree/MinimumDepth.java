package binarysearchtree;

public class MinimumDepth {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeftChild(new Node(2));
        root.setRightChild(new Node(3));
        root.getRightChild().setRightChild(new Node(4));
        root.getLeftChild().setRightChild(new Node(5));
        root.getLeftChild().setLeftChild(new Node(6));
        root.getLeftChild().getRightChild().setRightChild(new Node(7));

        System.out.println(minimumDepth(root));
        System.out.println(minimumDepthSolution2(root));

    }


    private static int minimumDepth(Node node) {
        int minDepth = Integer.MAX_VALUE;

        if (node != null) {
            int currentDepth = 1;
            int minDepthR = minimumDepthRec(node.getRightChild(), currentDepth, minDepth);
            int minDepthL = minimumDepthRec(node.getLeftChild(), currentDepth, minDepth);
            return Math.min(minDepthR, minDepthL);
        }

        return 0;
    }

    private static int minimumDepthRec(Node node, int currentDepth, int minDepth) {
        if(node!= null) {
            currentDepth++;

            if (node.getLeftChild() != null) {
                minDepth = minimumDepthRec(node.getLeftChild(), currentDepth, minDepth);
            }

            if (node.getRightChild() != null) {
                minDepth = minimumDepthRec(node.getRightChild(), currentDepth, minDepth);
            }

            if (node.getRightChild() == null && node.getLeftChild() == null) {
                return Math.min(minDepth, currentDepth);
            }
        }
        return minDepth;
    }

    private static int minimumDepthSolution2(Node root) {
        if (root == null)
            return 0;

        if (root.getLeftChild() == null && root.getRightChild() == null)
            return 1;

        if (root.getLeftChild() == null)
            return minimumDepthSolution2(root.getRightChild()) + 1;

        if (root.getRightChild() == null)
            return minimumDepthSolution2(root.getLeftChild()) + 1;

        return Math.min(minimumDepthSolution2(root.getLeftChild()),
                minimumDepthSolution2(root.getRightChild())) + 1;
    }

}
