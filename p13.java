import java.util.Scanner;
class QueueLogic {
static int[] queue = new int[25];
static int front = -1, rear = -1;
static int capacity = 25;
static void create(Scanner sc) {
System.out.print("Enter number of elements to initialize: ");
int count = sc.nextInt();
if (count < 0 || count > capacity) {
System.out.println("Invalid size. Limit is 0-25.");
return;
}
front = 0;
rear = -1;
System.out.println("Enter " + count + " elements:");
for (int i = 0; i < count; i++) {
queue[++rear] = sc.nextInt();
}
System.out.println("Queue created successfully.");
}
static boolean enqueue(int value) {
if (rear == capacity - 1) {
System.out.println("Overflow: Queue is full");
return false;
}
if (front == -1) front = 0;
queue[++rear] = value;
System.out.println("Added: " + value);
return true;
}
static boolean dequeue() {
if (front == -1 || front > rear) {
System.out.println("Underflow: Queue is empty");
return false;
}
System.out.println("Removed: " + queue[front]);
front++;
if (front > rear) {
front = rear = -1;
}
return true;
}
static void display() {
if (front == -1 || front > rear) {
System.out.println("Queue is empty");
return;
}
System.out.print("Queue Content: ");
for (int i = front; i <= rear; i++) {
System.out.print(queue[i] + " ");
}
System.out.println();
}
}
public class p13 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int choice;
do {
System.out.println("\n0. Create Queue");
System.out.println("1. Insert multiple");
System.out.println("2. Delete multiple");
System.out.println("3. Display");
System.out.println("4. Exit");
System.out.print("Select an option: ");
choice = sc.nextInt();
switch (choice) {
case 0:
QueueLogic.create(sc);
break;
case 1:
char proceed;
do {
System.out.print("Enter value to insert: ");
int val = sc.nextInt();
if (!QueueLogic.enqueue(val)) break;
System.out.print("Do you want to add another? (y/n): ");
proceed = sc.next().toLowerCase().charAt(0);
} while (proceed == 'y');
break;
case 2:
char delProceed;
do {
if (!QueueLogic.dequeue()) break;
System.out.print("Do you want to delete another? (y/n): ");
delProceed = sc.next().toLowerCase().charAt(0);
} while (delProceed == 'y');
break;
case 3:
QueueLogic.display();
break;
case 4:
System.out.println("Exiting...");
break;
default:
System.out.println("Invalid choice");
}
} while (choice != 4);
sc.close();
}
}
