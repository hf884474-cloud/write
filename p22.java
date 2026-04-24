import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head = null;
    Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.print("Nodes: ");
        while (current != null) {
            System.out.print("[" + current.data + "]");
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class p22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.print("How many nodes do you want to add");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter value for node " + (i + 1) + ": ");
            int value = sc.nextInt();
            list.addNode(value);
        }
        String choice;
        do {
            System.out.print("Do you want to add more nodes? (y/n): ");
            choice = sc.next();

            if (choice.equalsIgnoreCase("y")) {
                System.out.print("Enter value for node: ");
                int value = sc.nextInt();
                list.addNode(value);
            }
        } while (choice.equalsIgnoreCase("y"));
        list.display();
        System.out.println("Total number of nodes: " + list.countNodes());
        
        sc.close();
    }
}
