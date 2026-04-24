import java.util.Scanner;
class Queue {
int[] queue;
int front, rear, capacity;
Queue() {
capacity = 25;
queue = new int[capacity];
front = -1;
rear = -1;
}
void addDirectly(int value) {
if (rear == capacity - 1) {
System.out.println("Overflow error");
return;
}
if (front == -1) front = 0;
queue[++rear] = value;
}
void enqueue(Scanner sc) {
char choice = 'y';
while (choice == 'y' || choice == 'Y') {
if (rear == capacity - 1) {
System.out.println("Overflow error");
break;
}
System.out.print("Enter element: ");
int value = sc.nextInt();
if (front == -1) front = 0;
queue[++rear] = value;
System.out.print("Do you want to add more? (y/n): ");
choice = sc.next().charAt(0);
}
}
void display() {
if (front == -1 || front > rear) {
System.out.println("Queue is empty");
return;
}
System.out.print("Queue: ");
for (int i = front; i <= rear; i++) {
System.out.print(queue[i] + " ");
}
System.out.println();
}
}
public class p12 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Queue q = new Queue();
System.out.print("How many elements to add initially? ");
int count = sc.nextInt();
if (count > 25 || count < 0) {
System.out.print("Invalid size");
return;
} else {
for (int i = 1; i <= count; i++) {
System.out.print("Value " + i + ": ");
int val = sc.nextInt();
q.addDirectly(val);
}
System.out.println("Queue Created");
System.out.println("Starting enqueue operation:");
q.enqueue(sc);
}
System.out.println("\nFinal Queue contents:");
q.display();
sc.close();
}
}
