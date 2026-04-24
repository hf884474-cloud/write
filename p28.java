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


    public void insertAnywhere(int data, int pos) {
        Node newNode = new Node(data);
        

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            return;
        }


        if (pos <= 1) {
            newNode.next = head;
            head = newNode;
            tail.next = head;
            return;
        }


        Node temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;


        if (temp == tail) {
            tail = newNode;
        }
    }

    public void createList(Scanner sc) {
        head = null;
        tail = null;
        char more;
        int count = 1;
        
        do {
            System.out.print("Enter value for node " + count + ": ");
            insertAnywhere(sc.nextInt(), Integer.MAX_VALUE);
            count++;
            
            System.out.print("Add another node? (y/n): ");
            more = sc.next().toLowerCase().charAt(0);
        } while (more == 'y');
    }

    public void display() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Head: " + head.data + ")");
    }
}

public class p28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CircularLinkedList cll = new CircularLinkedList();
        int choice;

        do {
            System.out.println("1. Create ");
            System.out.println("2. Insert ");
            System.out.println("3. Display ");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    cll.createList(sc);
                    break;
                case 2:
                    char proceed;
                    do {
                        System.out.print("Value to insert: ");
                        int val = sc.nextInt();
                        System.out.print("Position: ");
                        int pos = sc.nextInt();
                        cll.insertAnywhere(val, pos);
                        
                        System.out.print("Insert another? (y/n): ");
                        proceed = sc.next().toLowerCase().charAt(0);
                    } while (proceed == 'y');
                    break;
                case 3:
                    cll.display();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        } while (choice != 4);
        sc.close();
    }
}
