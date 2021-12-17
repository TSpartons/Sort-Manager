package Model.Tree;

import Model.Sorter;
import Model.TestingFunctions;

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


    private long speed;
    private long start;
    private long end;

    @Override
    public long getSpeed()
    {
        return speed;
    }

    private void setSpeed() {
        speed = end - start;
    }

    //Adds nodes to tree then orders them in ascending order
    @Override
    public int[] Sort(int[] arr) {
        start = System.nanoTime();
        int i = 0;
        Node rootNode = new Node(arr[i]);
        ++i;
        for (i = 1; i < arr.length; ++i)
            rootNode.addNodeToTree(rootNode, arr[i]);
        rootNode.order(rootNode, arr);
        end = System.nanoTime();
        setSpeed();
        return arr;
    }

}
