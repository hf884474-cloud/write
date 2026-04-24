import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    public int display() {
        if (head == null) {
            System.out.println("List is empty.");
            return 0;
        }
        int count = 0;
        Node temp = head;
        do {
            System.out.print("[" + temp.data + "] -> ");
            count++;
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Head)");
        return count;
    }
}

public class p26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList myList = new CircularLinkedList();
        System.out.print("Enter number of nodes  ");
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            int val = sc.nextInt();
            myList.insert(val);
        }
        String choice;
        while (true) {
            System.out.print("Do you want to add a node? (y/n): ");
            choice = sc.next();
            
            if (choice.equalsIgnoreCase("y")) {
                System.out.print("Enter value for node: ");
                int val = sc.nextInt();
                myList.insert(val);
            } else {
                break;
            }
        }
        System.out.println("\n--- Circular Linked List ---");
        int total = myList.display();
        System.out.println("Total nodes found: " + total);

        sc.close();
    }
}
