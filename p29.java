import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head = null;

    // Standard insertion at the end
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Searches from Head to Tail
    String searchForward(int key) {
        Node temp = head;
        int pos = 1;
        StringBuilder foundPos = new StringBuilder();
        while (temp != null) {
            if (temp.data == key) {
                foundPos.append(pos).append(" ");
            }
            temp = temp.next;
            pos++;
        }
        return foundPos.length() == 0 ? "-1" : foundPos.toString().trim();
    }

    // Searches from Tail to Head
    String searchBackward(int key) {
        if (head == null) return "-1";
        
        // Step 1: Go to the tail
        Node temp = head;
        int count = 1;
        while (temp.next != null) {
            temp = temp.next;
            count++;
        }
        
        // Step 2: Traverse backward using the prev pointer
        StringBuilder foundPos = new StringBuilder();
        int currentPos = count;
        while (temp != null) {
            if (temp.data == key) {
                foundPos.append(currentPos).append(" ");
            }
            temp = temp.prev;
            currentPos--;
        }
        return foundPos.length() == 0 ? "-1" : foundPos.toString().trim();
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
        System.out.println();
    }
}

public class p29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList dll = new DoublyLinkedList();
        int choice;
        String result;

        while (true) {

            System.out.println("1. Create");
            System.out.println("2. Search Forward");
            System.out.println("3. Search Backward");
            System.out.println("4. Display List");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    char proceed;
                    do {
                        System.out.print("Enter value: ");
                        dll.insert(sc.nextInt());
                        System.out.print("Add another? (y/n): ");
                        proceed = sc.next().toLowerCase().charAt(0);
                    } while (proceed == 'y');
                    break;

                case 2:
                    System.out.print("Enter search key: ");
                    result = dll.searchForward(sc.nextInt());
                    System.out.println(result.equals("-1") ? "Not found" : "Found at positions: " + result);
                    break;

                case 3:
                    System.out.print("Enter search key: ");
                    result = dll.searchBackward(sc.nextInt());
                    System.out.println(result.equals("-1") ? "Not found" : "Found at positions: " + result);
                    break;

                case 4:
                    dll.display();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
