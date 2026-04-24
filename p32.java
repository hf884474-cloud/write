import java.util.Scanner;

class Queue {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public Queue() {
        this.front = null;
        this.rear = null;
    }

    public void create(Scanner sc) {
        front = rear = null;
        char choice;
        do {
            System.out.print("Enter value: ");
            enqueueLogic(sc.nextInt());
            System.out.print("Add another? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');
    }

    public void enqueueMultiple(Scanner sc) {
        char choice;
        do {
            System.out.print("Enter value to enqueue: ");
            enqueueLogic(sc.nextInt());
            System.out.print("Enqueue more? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');
    }

    private void enqueueLogic(int value) {
        Node newNode = new Node(value);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void multiDequeue(Scanner sc) {
        char choice;
        do {
            if (front == null) {
                System.out.println("Queue is empty.");
                break;
            }
            System.out.println(front.data + " removed.");
            front = front.next;
            if (front == null) rear = null;

            if (front == null) break;

            System.out.print("Dequeue more? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');
    }

    public void display() {
        if (front == null) {
            System.out.println("Queue: Empty");
            return;
        }
        Node temp = front;
        System.out.print("Queue: ");
        while (temp != null) {
            System.out.print(temp.data + (temp.next != null ? " -> " : ""));
            temp = temp.next;
        }
        System.out.println();
    }
}

public class p32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();

        while (true) {
            System.out.println("\n1. Create\n2. Enqueue\n3. Dequeue\n4. Display\n5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: q.create(sc); break;
                case 2: q.enqueueMultiple(sc); break;
                case 3: q.multiDequeue(sc); break;
                case 4: q.display(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid!");
            }
        }
    }
}
