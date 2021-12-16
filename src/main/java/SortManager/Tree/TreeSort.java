package SortManager.Tree;

import SortManager.Sorter;
import SortManager.TestingFunctions;

public class TreeSort implements Sorter {

    private class Node {
        public final int value;
        Node left;
        Node right;

        public Node (int value) {this.value = value;}

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public boolean leftChildEmpty() {
            if (left == null)
                return true;
            return false;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public boolean rightChildEmpty() {
            if(right == null)
                return true;
            return false;
        }

        public void addNodeToTree(Node node, int value){
            if(value <= node.value) {
                if(node.leftChildEmpty())
                    node.setLeft(new Node(value));
                else
                    addNodeToTree(node.getLeft(),value);
            }
            else {
                if (node.rightChildEmpty())
                    node.setRight(new Node(value));
                else
                    addNodeToTree(node.getRight(), value);
            }
        }

        int index = 0;

        //order the nodes in numerical order and pass the values one at a time
        public void order(Node rootNode, int[] arr) {

            if(rootNode != null) {
                order(rootNode.left, arr);
                arr[index] = rootNode.value;
                ++index;
               // System.out.println(rootNode.value);
                order(rootNode.right, arr);
            }
        }



    }

    //Adds nodes to tree then orders them in ascending order
    @Override
    public int[] Sort(int[] arr) {
        int i = 0;
        Node rootNode = new Node(arr[i]);
        ++i;
        for (i = 1; i < arr.length; ++i)
            rootNode.addNodeToTree(rootNode, arr[i]);
        rootNode.order(rootNode, arr);
        return arr;
    }

    public static void main(String[] args) {
        TestingFunctions testingFunctions = new TestingFunctions();
        //Given an array
        int[] array = {12, 18, 9, 6, 100};
        TreeSort treeSort = new TreeSort();
        testingFunctions.arrToString(treeSort.Sort(array));
    }

}
