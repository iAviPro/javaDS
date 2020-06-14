/* Binary Tree Traversal: Level-Order-Traversal using recursion.
 * Time Complexity: O(n^2) in worst case, when using recursion.
 * if using qeueues for level-order, then time complexity is O(n)
 */
/* 
@Author: Aviral Nigam
*/
 
/* Class containing left and right child of current 
   node and key value*/
class Node
{
    int data;
    Node left, right;
     /*Node constructor to initialize value*/
    public Node(int item)
    {
        data = item;
        left = right = null;
    }
}
 
public class BinaryTreeBFSRec
{
    // Root of the Binary Tree
    Node root;
    //constructor to initialize root to null
    public BinaryTreeBFSRec()
    {
        root = null;
    }
 
    /* function to print level order traversal of tree*/
    void printLevelOrder()
    {
        int h = height(root);
        int i;
        for (i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
 
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            /* compute  height of each subtree */
            int lheight = height(root.left); //computes the left height and stores in lheight variable
            int rheight = height(root.right); //computes the right height and stores in rheight vaiable
             
            /* use the larger one */
            if (lheight > rheight)
                return(lheight+1); //adding 1 for counting root
            else return(rheight+1); 
        }
    }
 
    /* Print nodes at the given level */
    void printGivenLevel (Node root ,int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " "); //prints the nodes of the given level
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1); //decrement the level counter to only print the nodes of given level
            printGivenLevel(root.right, level-1);
            /*while recursion stack backtracks from left recursion, level values again get greater than 1 
            hence they are not printed. Only when recursion reaches the level value to 1 in the right recursion,
            the node data for that level is printed. */
        }
    }
     
    /* Driver program to test above functions */
    public static void main(String args[])
    {
       BinaryTreeBFSRec tree = new BinaryTreeBFSRec();
       tree.root= new Node(1);
       tree.root.left= new Node(2);
       tree.root.right= new Node(3);
       tree.root.left.left= new Node(4);
       tree.root.left.right= new Node(5);
       //can further add/modify nodes to define the tree structure.
       System.out.println("Level order traversal of binary tree is: ");
       tree.printLevelOrder();
       System.out.print("\n");
    }
}