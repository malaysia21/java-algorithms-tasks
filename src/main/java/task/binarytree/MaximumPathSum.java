package task.binarytree;

public class MaximumPathSum {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.setLeftChild(new Node(2));
        root.setRightChild(new Node(3));
        root.getRightChild().setRightChild(new Node(4));
        root.getLeftChild().setRightChild(new Node(20));
        root.getLeftChild().setLeftChild(new Node(6));
        root.getRightChild().getRightChild().setRightChild(new Node(8));

        System.out.println("Version 1 - max single side "  + maxPathSumVersion1(root));
        Result result = new Result(Integer.MIN_VALUE);
        System.out.println("Version 2 - max single side: " + maxPathSumVersion2(root, result) +  ", max both side: " + result.getResult());


    }
    private static int maxPathSumVersion1(Node root) {
        if (root == null) {
            return 0;
        }
        int value = root.getValue();
        int leftChildren = 0;
        int rightChildren = 0;

        if (root.getLeftChild() != null) {
            leftChildren = Math.max(value, maxPathSumVersion1(root.getLeftChild()) + value);
        }

        if (root.getRightChild() != null) {
            rightChildren = Math.max(value, maxPathSumVersion1(root.getRightChild()) + value);
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return value;
        }

        return Math.max(leftChildren, rightChildren);
    }

    private static int maxPathSumVersion2(Node node, Result result) {
        if (node == null) {
            return 0;
        }
        int leftChildren = maxPathSumVersion2(node.getLeftChild(), new Result(result.getResult()));
        int rightChildren = maxPathSumVersion2(node.getRightChild(), new Result(result.getResult()));

        int maxSingleSide = Math.max(Math.max(leftChildren, rightChildren) + node.getValue(), node.getValue());
        int maxBothSide = Math.max(maxSingleSide, leftChildren + rightChildren + node.getValue());

        result.setResult(Math.max(result.getResult(), maxBothSide));

        return maxSingleSide;
    }



}
