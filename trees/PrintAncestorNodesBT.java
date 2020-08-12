package trees;
/* Binary Tree: Print ancestors of a given node of binary tree (Recursive solution)
 * Time complexity(Worst case) -  O(n) {n-no. of nodes}
 * Algo:
 * 1. Traverse right of the tree and left of the tree
 * 2. Condition check if the key is found in either left or right of the tree.
 * 3. If found in any side print the data value of every node while traversing to that node.
 */
/**
 * @author: Aviral Nigam
 */

class PrintAncestorNodesBT {

    // A binary tree node
    class Node {
        int data;
        Node left, right, nextRight;

        // Node constructor to initialize values
        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }
    }

    static Node root;

    /* If target is present in tree, then prints the ancestors
     and returns true, otherwise returns false. */
    boolean printAncestors(Node node, int target) {

         /* base cases */
        if (node == null) {
            return false;
        }
        //condition check to find the given key
        if (node.data == target) {
            return true;
        }

        /* If target is present in either left or right subtree of this node,
         then print this node */
        if (printAncestors(node.left, target)
                || printAncestors(node.right, target)) {
            System.out.print(node.data + " ");
            return true;
        }

        /* Else return false */
        return false;
    }

    public static void main(String args[]) {
        PrintAncestorNodesBT tree = new PrintAncestorNodesBT();
        tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        tree.root.left.left.left = tree.new Node(7);
        //edit/remove the above statements to define the structure of the tree
        tree.printAncestors(root, 7); //edit parameter of this statement to find another key
        System.out.print("\n"); //Print newline to demarcate the output clearly.

    }
}
