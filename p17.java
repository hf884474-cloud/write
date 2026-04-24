import java.util.Scanner;
class Deque {
private int front, rear, size, maxSize = 10;
private int[] deque = new int[maxSize];
public void create(Scanner sc) {
this.front = -1;
this.rear = -1;
this.size = 0;
System.out.print("Enter initial number of elements: ");
int n = sc.nextInt();
if (n > maxSize) n = maxSize;
for (int i = 0; i < n; i++) {
System.out.print("Value " + (i + 1) + ": ");
insertRearValue(sc.nextInt());
}
}
private void insertRearValue(int value) {
if (size == maxSize) return;
if (front == -1) { front = 0; rear = 0; }
else { rear = (rear + 1) % maxSize; }
deque[rear] = value;
size++;
}
public boolean isFull() { return size == maxSize; }
public boolean isEmpty() { return size == 0; }
public void insertFrontInteractive(Scanner sc) {
char choice = 'y';
while (choice == 'y' || choice == 'Y') {
if (isFull()) {
System.out.println("Overflow!");
break;
}
System.out.print("Enter value: ");
int value = sc.nextInt();
if (front == -1) { front = 0; rear = 0; }
else { front = (front - 1 + maxSize) % maxSize; }
deque[front] = value;
size++;
System.out.print("Insert another at front? (y/n): ");
choice = sc.next().charAt(0);
}
}
public void insertRearInteractive(Scanner sc) {
char choice = 'y';
while (choice == 'y' || choice == 'Y') {
if (isFull()) {
System.out.println("Overflow!");
break;
}
System.out.print("Enter value: ");
int value = sc.nextInt();
if (front == -1) { front = 0; rear = 0; }
else { rear = (rear + 1) % maxSize; }
deque[rear] = value;
size++;
System.out.print("Insert another at rear? (y/n): ");
choice = sc.next().charAt(0);
}
}
public void deleteFrontInteractive(Scanner sc) {
char choice = 'y';
while (choice == 'y' || choice == 'Y') {
if (isEmpty()) {
System.out.println("Underflow!");
break;
}
System.out.println("Deleted Front: " + deque[front]);
if (front == rear) { front = -1; rear = -1; }
else { front = (front + 1) % maxSize; }
size--;
if (isEmpty()) break;
System.out.print("Delete another from front? (y/n): ");
choice = sc.next().charAt(0);
}
}
public void deleteRearInteractive(Scanner sc) {
char choice = 'y';
while (choice == 'y' || choice == 'Y') {
if (isEmpty()) {
System.out.println("Underflow!");
break;
}
System.out.println("Deleted Rear: " + deque[rear]);
if (front == rear) { front = -1; rear = -1; }
else { rear = (rear - 1 + maxSize) % maxSize; }
size--;
if (isEmpty()) break;
System.out.print("Delete another from rear? (y/n): ");
choice = sc.next().charAt(0);
}
}
public void display() {
if (isEmpty()) {
System.out.println("Empty!");
return;
}
System.out.print("Deque: ");
int i = front;
for (int count = 0; count < size; count++) {
System.out.print(deque[i] + " ");
i = (i + 1) % maxSize;
}
System.out.println();
}
}
public class p17 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Deque dq = new Deque();
while (true) {
System.out.println("\n1.Create | 2.Insert Front | 3.Insert Rear");
System.out.println("4.Delete Front | 5.Delete Rear | 6.Display | 7.Exit");
System.out.print("Enter Choice: ");
int choice = scanner.nextInt();
switch (choice) {
case 1: dq.create(scanner); break;
case 2: dq.insertFrontInteractive(scanner); break;
case 3: dq.insertRearInteractive(scanner); break;
case 4: dq.deleteFrontInteractive(scanner); break;
case 5: dq.deleteRearInteractive(scanner); break;
case 6: dq.display(); break;
case 7: return;
default: System.out.println("Invalid Choice!");
}
}
}
}
