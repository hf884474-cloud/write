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

    public void clear() {
        head = null;
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        System.out.println("Added " + data);
    }

    public void deleteByPosition(int position) {
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }
        Node temp = head;
        if (position == 1) {
            head = temp.next;
            System.out.println("Node at position " + position + " deleted.");
            return;
        }
        Node prev = null;
        for (int i = 1; temp != null && i < position; i++) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position " + position + " is out of bounds.");
            return;
        }
        prev.next = temp.next;
        System.out.println("Node at position " + position + " deleted.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("Current List: ");
        while (temp != null) {
            System.out.print("[" + temp.data + "]");
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class p23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int choice;

        do {
            System.out.println("0. Create New List");
            System.out.println("1. Delete Nodes");
            System.out.println("2. Display Linkedlist");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 0:
                    list.clear();
                    System.out.print("How many nodes to add? ");
                    int count = sc.nextInt();
                    for (int i = 0; i < count; i++) {
                        System.out.print("Enter value " + (i + 1) + ": ");
                        list.addNode(sc.nextInt());
                    }
                    break;
                case 1:
                    if (list.head == null) {
                        System.out.println("Error: List is empty. Nothing to delete.");
                    } else {
                        char proceedDel;
                        do {
                            System.out.print("Enter the position to delete: ");
                            int pos = sc.nextInt();
                            list.deleteByPosition(pos);
                            
                            if (list.head == null) {
                                System.out.println("List is now empty.");
                                break; 
                            }
                            System.out.print("Do you want to delete another node? (y/n): ");
                            proceedDel = sc.next().toLowerCase().charAt(0);
                        } while (proceedDel == 'y');
                    }
                    break;

                case 2:
                    list.display();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 3);

        sc.close();
    }
}
