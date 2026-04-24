import java.util.Scanner;
class p11 {
int[] queue;
int front, rear, capacity;
p11(int size) {
capacity = size;
queue = new int[capacity];
front = -1;
rear = -1;
}
void enqueueValue(int value) {
if (rear == capacity - 1) {
System.out.println("Overflow! Cannot add " + value);
return;
}
if (front == -1) front = 0;
queue[++rear] = value;
}
void enqueue(Scanner sc) {
char continuePush = 'y';
while (continuePush == 'y' || continuePush == 'Y') {
if (rear == capacity - 1) {
System.out.println("Overflow!");
break;
}
System.out.print("Enter value: ");
int value = sc.nextInt();
if (front == -1) front = 0;
queue[++rear] = value;
System.out.print("Do you want to enqueue more? (y/n): ");
continuePush = sc.next().charAt(0);
}
}
void dequeue(Scanner sc) {
char continuePop = 'y';
while (continuePop == 'y' || continuePop == 'Y') {
if (front == -1 || front > rear) {
System.out.println("Underflow!");
break;
}
System.out.println(queue[front] + " removed");
front++;
if (front > rear) {
System.out.println("Queue is now empty.");
front = rear = -1;
break;
}
System.out.print("Do you want to dequeue more? (y/n): ");
continuePop = sc.next().charAt(0);
}
}
void display() {
if (front == -1 || front > rear) {
System.out.println("Queue is empty.");
return;
}
System.out.print("Current Queue: ");
for (int i = front; i <= rear; i++) {
System.out.print(queue[i] + " ");
}
System.out.println();
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
p11 q = new p11(25);
System.out.print("How many elements to add initially? ");
int count = sc.nextInt();
if(count>25||count<0){
System.out.print("Invalide size");
return;
}else{
for (int i = 1; i <= count; i++) {
System.out.print("Value " + i + ": ");
int val = sc.nextInt();
q.enqueueValue(val);
}}
System.out.println("\n--- Additional Enqueue Operations ---");
q.enqueue(sc);
System.out.println("\nFinal Queue before deletions:");
q.display();
System.out.println("\n--- Dequeue Operation ---");
q.dequeue(sc);
System.out.println("\nQueue after deletions:");
q.display();
sc.close();
}
}
