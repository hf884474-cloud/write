import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    Node head = null;

    public void createList(Scanner sc) {
        head = null; 
        char repeat;
        do {
            System.out.print("Enter value: ");
            insertEnd(sc.nextInt());
            System.out.print("Add another? (y/n): ");
            repeat = sc.next().toLowerCase().charAt(0);
        } while (repeat == 'y');
    }

    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        newNode.prev = null;
        if (head != null) head.prev = newNode;
        head = newNode;
    }

    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void deleteByPosition(int pos) {
        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        Node temp = head;
        if (pos == 1) {
            head = temp.next;
            if (head != null) head.prev = null;
            return;
        }
        for (int i = 1; temp != null && i < pos; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Out of range.");
            return;
        }
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    public void searchForward(int key) {
        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        Node temp = head;
        int pos = 1;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Found " + key + " at position " + pos + " (Forward)");
                return;
            }
            temp = temp.next;
            pos++;
        }
        System.out.println("Not found.");
    }

    public void searchBackward(int key) {
        if (head == null) {
            System.out.println("List empty.");
            return;
        }
        Node temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        
        int pos = count;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Found " + key + " at position " + pos + " (Backward)");
                return;
            }
            temp = temp.prev;
            pos--;
        }
        System.out.println("Not found.");
    }

    public void display() {
        if (head == null) {
            System.out.println("List: Empty");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " <-> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }
}

public class p30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int choice, val, pos;
        char repeat;

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Create\n2. Insert Front\n3. Insert End\n4. Delete Position");
            System.out.println("5. Search Forward\n6. Search Backward\n7. Display\n8. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    dll.createList(sc);
                    dll.display();
                    break;
                case 2:
                    do {
                        System.out.print("Value: "); val = sc.nextInt();
                        dll.insertFront(val);
                        System.out.print("Insert more? (y/n): ");
                        repeat = sc.next().toLowerCase().charAt(0);
                    } while (repeat == 'y');
                    dll.display();
                    break;
                case 3:
                    do {
                        System.out.print("Value: "); val = sc.nextInt();
                        dll.insertEnd(val);
                        System.out.print("Insert more? (y/n): ");
                        repeat = sc.next().toLowerCase().charAt(0);
                    } while (repeat == 'y');
                    dll.display();
                    break;
                case 4:
                    do {
                        if (dll.head == null) {
                            System.out.println("List empty.");
                            break;
                        }
                        System.out.print("Position: "); pos = sc.nextInt();
                        dll.deleteByPosition(pos);
                        dll.display();
                        if (dll.head == null) break;
                        System.out.print("Delete more? (y/n): ");
                        repeat = sc.next().toLowerCase().charAt(0);
                    } while (repeat == 'y');
                    break;
                case 5:
                    System.out.print("Search Forward: ");
                    dll.searchForward(sc.nextInt());
                    break;
                case 6:
                    System.out.print("Search Backward: ");
                    dll.searchBackward(sc.nextInt());
                    break;
                case 7:
                    dll.display();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Invalid!");
            }
        }
    }
}
