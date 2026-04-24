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
Node head;

public void createList(Scanner sc) {
head = null;
System.out.print("How many nodes do you want to create? ");
int n = sc.nextInt();
if (n <= 0) return;
for (int i = 1; i <= n; i++) {
System.out.print("Enter value for node " + i + ": ");
int value = sc.nextInt();
insertAtAnyPosition(value, i);
}
System.out.println("List created successfully.");
}

public void insertAtAnyPosition(int data, int position) {
if (position < 1) {
System.out.println("Error: Position must be 1 or greater.");
return;
}
Node newNode = new Node(data);
if (position == 1) {
newNode.next = head;
head = newNode;
return;
}
Node temp = head;
for (int i = 1; temp != null && i < position - 1; i++) {
temp = temp.next;
}
if (temp == null) {
System.out.println("Error: Position out of bounds.");
} else {
newNode.next = temp.next;
temp.next = newNode;
}
}

public void deleteByPosition(int position) {
if (head == null) {
System.out.println("List is empty.");
return;
}
if (position < 1) {
System.out.println("Error: Position must be 1 or greater.");
return;
}
Node temp = head;
if (position == 1) {
head = temp.next;
System.out.println("Deleted node at position 1.");
return;
}
Node prev = null;
for (int i = 1; temp != null && i < position; i++) {
prev = temp;
temp = temp.next;
}
if (temp == null) {
System.out.println("Error: Position out of bounds.");
return;
}
prev.next = temp.next;
System.out.println("Deleted node at position " + position);
}

public void display() {
if (head == null) {
System.out.println("The list is currently empty.");
return;
}
Node temp = head;
System.out.print("List Content: ");
while (temp != null) {
System.out.print(temp.data + " -> ");
temp = temp.next;
}
System.out.println("NULL");
}
}

public class p24 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
LinkedList list = new LinkedList();
int choice;
while (true) {
System.out.println("1. Create List");
System.out.println("2. Insert at Any Position");
System.out.println("3. Display List");
System.out.println("4. Exit");
System.out.print("Enter choice: ");
choice = sc.nextInt();
switch (choice) {
case 1:
list.createList(sc);
break;
case 2:
char contIns;
do {
System.out.print("Enter value: ");
int val = sc.nextInt();
System.out.print("Enter position: ");
int pos = sc.nextInt();
list.insertAtAnyPosition(val, pos);
System.out.print("Do you want to insert more? (y/n): ");
contIns = sc.next().toLowerCase().charAt(0);
} while (contIns == 'y');
break;
case 3:
list.display();
break;
case 4:
System.out.println("Exiting...");
sc.close();
return;
default:
System.out.println("Invalid choice!");
}
}
}
}
