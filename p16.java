import java.util.Scanner;
class CircularQueue {
private int front, rear, size, maxSize;
private int[] queue;
public CircularQueue(int initSize, int[] initValues) {
maxSize = 10;
size = 0;
queue = new int[maxSize];
front = 0;
rear = -1;
for (int i = 0; i < initSize; i++) {
enqueue(initValues[i]);
}
}
public boolean isEmpty() { return size == 0; }
public boolean isFull() { return size == maxSize; }
public void enqueue(int value) {
if (isFull()) {
System.out.println("Queue is Full!");
return;
}
rear = (rear + 1) % maxSize;
queue[rear] = value;
size++;
}
public void dequeue() {
if (isEmpty()) {
System.out.println("Queue is Empty!");
return;
}
System.out.println("Deleted: " + queue[front]);
front = (front + 1) % maxSize;
size--;
}
public void display() {
if (isEmpty()) {
System.out.println("Queue is Empty!");
return;
}
System.out.print("Queue: ");
int i = front, count = 0;
while (count < size) {
System.out.print(queue[i] + " ");
i = (i + 1) % maxSize;
count++;
}
System.out.println();
}
}
public class p16 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
CircularQueue queue = null;
while (true) {
System.out.println("1. Create 2. Push 3. Pop 4. Display 5. Exit");
System.out.print("Choice: ");
int choice = scanner.nextInt();
switch (choice) {
case 1:
int initSize;
while (true) {
System.out.print("Enter initial size (0-10): ");
initSize = scanner.nextInt();
if (initSize >= 0 && initSize <= 10) break;
System.out.println("Invalid size.");
}
int[] initValues = new int[initSize];
if (initSize > 0) {
System.out.println("Enter " + initSize + " values:");
for (int i = 0; i < initSize; i++) initValues[i] = scanner.nextInt();
}
queue = new CircularQueue(initSize, initValues);
System.out.println("Queue created.");
break;
case 2:
if (queue == null) {
System.out.println("Create a queue first!");
break;
}
char pushMore = 'y';
while (pushMore == 'y' || pushMore == 'Y') {
if (queue.isFull()) {
System.out.println("Queue is full!");
break;
}
System.out.print("Enter value to push: ");
queue.enqueue(scanner.nextInt());
System.out.print("Push another? (y/n): ");
pushMore = scanner.next().charAt(0);
}
break;
case 3:
if (queue == null) {
System.out.println("Create a queue first!");
break;
}
char popMore = 'y';
while (popMore == 'y' || popMore == 'Y') {
if (queue.isEmpty()) {
System.out.println("Queue is empty!");
break;
}
queue.dequeue();
if (queue.isEmpty()) break;
System.out.print("Pop another? (y/n): ");
popMore = scanner.next().charAt(0);
}
break;
case 4:
if (queue == null) {
System.out.println("Queue not created!");
} else {
queue.display();
}
break;
case 5:
System.out.println("Exiting...");
return;
default:
System.out.println("Invalid choice!");
}
}
}
}
