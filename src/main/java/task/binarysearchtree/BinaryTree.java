package task.binarysearchtree;

import lombok.Data;

public class BinaryTree {
    private Node root;

    private void addNode(int key, String name) {
        Node newNode = new Node(key, name);

        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.getKey()) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    focusNode = focusNode.getRightChild();

                    if (focusNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }
    }

    private void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            inOrderTraverseTree(focusNode.getLeftChild());
            System.out.println(focusNode);
            inOrderTraverseTree(focusNode.getRightChild());
        }
    }

    private void preOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            System.out.println(focusNode);
            preOrderTraverseTree(focusNode.getLeftChild());
            preOrderTraverseTree(focusNode.getRightChild());
        }
    }


    private void postOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            postOrderTraverseTree(focusNode.getLeftChild());
            postOrderTraverseTree(focusNode.getRightChild());
            System.out.println(focusNode);
        }
    }

    private Node findNode(int key) {
        Node focusNode = root;

        while (focusNode.getKey() != key) {

            if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else {
                focusNode = focusNode.getRightChild();
            }

            if(focusNode == null){
                return null;
            }
        }
        return focusNode;
    }

    private Node findNode2(int key) {
        Node focusNode = root;

        while (focusNode != null) {

            if (key < focusNode.getKey()) {
                focusNode = focusNode.getLeftChild();
            } else if(key > focusNode.getKey()) {
                focusNode = focusNode.getRightChild();
            } else {
                return focusNode;
            }
        }
        return null;
    }

    private boolean remove(int key){
        Node focusNode = root;
        Node parent =  root;

        boolean isItLeftChild = true;

        while(focusNode.getKey() != key){

            parent =  focusNode;

            if(key< focusNode.getKey()){
                isItLeftChild = true;
                focusNode = focusNode.getLeftChild();
            } else {
                isItLeftChild = false;
                focusNode = focusNode.getRightChild();
            }

            if(focusNode == null){
                return false;
            }
        }

        if(focusNode.getLeftChild() == null && focusNode.getRightChild() == null){

            if(focusNode == root) {
                root = null;
            }
            else if(isItLeftChild) {
                parent.setRightChild(null);
            } else {
                parent.setRightChild(null);
            }
        }

        else if(focusNode.getRightChild() == null){
            if(focusNode == root) {
                root = focusNode.getLeftChild();
            } else if(isItLeftChild){
                parent.setLeftChild(focusNode.getLeftChild());
            } else {
                parent.setRightChild(focusNode.getLeftChild());
            }
        }

        else if(focusNode.getLeftChild() == null){
            if(focusNode == root) {
                root = focusNode.getRightChild();
            } else if(isItLeftChild){
                parent.setLeftChild(focusNode.getRightChild());
            } else {
                parent.setRightChild(focusNode.getRightChild());
            }
        } else {

            Node replacement = getReplacement(focusNode);

            if(focusNode == root){
                root = replacement;
            } else if(isItLeftChild){
                parent.setLeftChild(replacement);
            } else {
                parent.setRightChild(replacement);
            }
            replacement.setLeftChild(focusNode.getLeftChild());
        }
        return true;
    }

    private Node getReplacement(Node replaceNode) {
        Node replacementParent = replaceNode;
        Node replacement = replaceNode;

        Node focusNode = replaceNode.getRightChild();

        while(focusNode!= null){
            replacementParent = replacement;
            replacement = focusNode;
            focusNode = focusNode.getLeftChild();
        }

        if(replacement!= replaceNode.getRightChild()){
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(replaceNode.getRightChild());
        }
        return replacement;
    }

    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.addNode(50, "Anna");
        binaryTree.addNode(25, "Tom");
        binaryTree.addNode(15, "Kate");
        binaryTree.addNode(30, "Helen");
        binaryTree.addNode(75, "Bob");
        binaryTree.addNode(85, "Joy");

        System.out.println("In order traversal: ");
        binaryTree.inOrderTraverseTree(binaryTree.root);

        System.out.println("Pre order traversal: ");
        binaryTree.preOrderTraverseTree(binaryTree.root);

        System.out.println("Post order traversal: ");
        binaryTree.postOrderTraverseTree(binaryTree.root);

        System.out.println("Search for 30");
        System.out.println(binaryTree.findNode(30));

        System.out.println("Search for 75");
        System.out.println(binaryTree.findNode2(75));

        System.out.println("Remove 25");
        System.out.println(binaryTree.remove(25));
        binaryTree.inOrderTraverseTree(binaryTree.root);
    }
}

@Data
class Node {

    private int key;
    private String name;

    private Node leftChild;
    private Node rightChild;

     Node(int key, String name) {
        this.key = key;
        this.name = name;
    }

    public String toString() {
        return name + " has o key " + key;
    }

}
