/** 
 * ITERATIVE APPROACH :
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Solution:
 * 1. Initialize three pointers previous as NULL, current as head and nextNode as NULL.
 * 2. Iterate through the linked list. In loop, do following. 
        // Before changing next of current, 
        // store next node 
        nextNode = current.next
        // Now change next of current 
        //This is where actual reversing happens 
        current.next = previous
        // Move previous and current one step forward 
        previous = current
        current = nextNode
*/

/**
 * RECURSIVE APPROACH
 * Time Complexity: O(n)  
 * Space Complexity: O(n) - Extra space comes from the implicit stack space due to recursion. THe recursion could go upto n levels deep.
 * Solution:
 * 1. Divide the Array into 2 parts - 1st Node and rest of the nodes.
 * 2. Call recursively the reverse method on the rest of the linked list.
 * 3. Link rest of the nodes to the first node
 * 4. Fix the head pointer
 */

package linkedlists;
import java.util.*;
public class ReverseLinkedList {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) {
        while (node != null) {
            System.out.print(node.data + "" + sep);
            node = node.next;
        }
    }

    // Complete the reversePrint function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static void reversePrintIterative(SinglyLinkedListNode head) {
        SinglyLinkedListNode previous =  null;
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode nextNode = null;
        if (head == null)
            return;
        while(current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
    head = previous;
    printSinglyLinkedList(head,"\n");
    }

    static SinglyLinkedListNode reversePrintRecursive(SinglyLinkedListNode head) {
        //SinglyLinkedListNode current = head;
        if (head == null || head.next == null)
            return head;
        // reverse the rest of the list and put the first element at the end
        SinglyLinkedListNode rest = reversePrintRecursive(head.next);
        head.next.next = head;
        // as head is still pointed to null 
        head.next = null;
        return rest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int testsItr = 0; testsItr < tests; testsItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();
            // newlinkedlist for running the same list through recursive print method as well.
            SinglyLinkedList newLinkedList = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
                newLinkedList.insertNode(llistItem);
            }
            
            // Iterative
            System.out.println("Iterative Print:");
            reversePrintIterative(llist.head);
           // Recursive
            System.out.println("Recursive Print:");
            SinglyLinkedListNode node = reversePrintRecursive(newLinkedList.head);
            printSinglyLinkedList(node, "\n");
        }

        scanner.close();
    }
}

