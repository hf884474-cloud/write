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
    Node head = null;
    Node tail = null;
    int nodeCount = 1; 


    public void createList(int data) {
        insertAtEnd(data);
        nodeCount++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
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

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head;
        }
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head: " + head.data + ")");
    }
}

public class p27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();
        int choice;

        do {
            System.out.println("1. Create");
            System.out.println("2. Insert at Beginning");
            System.out.println("3. Display List");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    char continueInserting;
                    do {
                        System.out.print("Enter value for node " + cll.nodeCount + ": ");
                        int val = sc.nextInt();
                        cll.createList(val);
                        
                        System.out.print("Do you want to continue? (y/n): ");
                        continueInserting = sc.next().toLowerCase().charAt(0);
                    } while (continueInserting == 'y');
                    break;

                case 2:
                    char continueInserting1;
                    do {
                        System.out.print("Enter value: ");
                        cll.insertAtBeginning(sc.nextInt());
                        
                        System.out.print("Do you want to insert more? (y/n): ");
                        continueInserting1 = sc.next().toLowerCase().charAt(0);
                    } while (continueInserting1 == 'y');
                    break;

                case 3:
                    cll.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }
}
