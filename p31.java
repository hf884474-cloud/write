import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Stack {
    private Node top;

    public Stack() {
        this.top = null;
    }

    public void create(Scanner sc) {
        top = null; 
        char choice;
        do {
            System.out.print("Enter value: ");
            pushLogic(sc.nextInt());
            System.out.print("Add another? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');
    }

    public void pushWithPrompt(Scanner sc) {
        char choice;
        do {
            System.out.print("Enter value to push: ");
            pushLogic(sc.nextInt());
            System.out.print("Push more? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');
    }

    private void pushLogic(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }

    public void popWithPrompt(Scanner sc) {
        char choice;
        do {
            if (top == null) {
                System.out.println("Stack empty.");
                break;
            }
            System.out.println(top.data + " popped.");
            top = top.next;

            if (top == null) break;

            System.out.print("Pop more? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');
    }

    public void peek() {
        if (top == null) System.out.println("Stack empty.");
        else System.out.println("Top: " + top.data);
    }

    public void display() {
        if (top == null) {
            System.out.println("Stack: Empty");
            return;
        }
        Node temp = top;
        System.out.print("Stack: ");
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }
}

public class p31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack stack = new Stack();
        
        while (true) {
            System.out.println("\n1. Create\n2. Push\n3. Pop\n4. Peek\n5. Display\n6. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1: stack.create(sc); break;
                case 2: stack.pushWithPrompt(sc); break;
                case 3: stack.popWithPrompt(sc); break;
                case 4: stack.peek(); break;
                case 5: stack.display(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid!");
            }
        }
    }
}
