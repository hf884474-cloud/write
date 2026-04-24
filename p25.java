
import java.util.Scanner;

class Node {
int data;
Node next;
Node(int data) {
this.data = data;
this.next = null;
}
}

class LinkedListOperations {
private Node head = null;
private Scanner sc = new Scanner(System.in);

public void create() {
head = null;
System.out.print("How many nodes to add? ");
int initialCount = sc.nextInt();
for (int i = 0; i < initialCount; i++) {
System.out.print("Enter value " + (i + 1) + ": ");
insertAtEnd(sc.nextInt());
}
}

public void insertAnywhere() {
char proceed;
do {
System.out.print("Enter value ");
int data = sc.nextInt();
System.out.print("Enter position ");
int pos = sc.nextInt();
Node newNode = new Node(data);
if (pos == 1) {
newNode.next = head;
head = newNode;
System.out.println("Inserted " + data + " at position 1");
} else {
Node temp = head;
for (int i = 1; temp != null && i < pos - 1; i++) {
temp = temp.next;
}
if (temp == null) {
System.out.println("Invalid position!");
} else {
newNode.next = temp.next;
temp.next = newNode;
System.out.println("Inserted " + data + " at position " + pos);
}
}
System.out.print("Do you want to add another node? (y/n): ");
proceed = sc.next().toLowerCase().charAt(0);
} while (proceed == 'y');
}

private void insertAtEnd(int data) {
Node newNode = new Node(data);
if (head == null) {
head = newNode;
} else {
Node temp = head;
while (temp.next != null) temp = temp.next;
temp.next = newNode;
}
}

public void deleteByPosition() {
if (head == null) {
System.out.println("Empty list.");
return;
}
char proceed;
do {
System.out.print("Enter position to delete: ");
int pos = sc.nextInt();
if (pos == 1) {
System.out.println("Deleted node at position 1: " + head.data);
head = head.next;
} else {
Node temp = head;
Node prev = null;
for (int i = 1; temp != null && i < pos; i++) {
prev = temp;
temp = temp.next;
}
if (temp == null) {
System.out.println("Position out of bounds.");
} else {
System.out.println("Deleted node at position " + pos + ": " + temp.data);
prev.next = temp.next;
}
}
if (head == null) {
System.out.println("List is now empty.");
break;
}
System.out.print("Do you want to delete another node? (y/n): ");
proceed = sc.next().toLowerCase().charAt(0);
} while (proceed == 'y');
}

public void traverse() {
if (head == null) {
System.out.println("List is empty.");
return;
}
Node temp = head;
while (temp != null) {
System.out.print(temp.data + " -> ");
temp = temp.next;
}
System.out.println("null");
}
}

public class p25 {
public static void main(String[] args) {
LinkedListOperations list = new LinkedListOperations();
Scanner scanner = new Scanner(System.in);
int choice;
do {
System.out.println("1. Create");
System.out.println("2. Insert");
System.out.println("3. Delete");
System.out.println("4. Traverse");
System.out.println("5. Exit");
System.out.print("Choice: ");
choice = scanner.nextInt();
switch (choice) {
case 1: list.create(); break;
case 2: list.insertAnywhere(); break;
case 3: list.deleteByPosition(); break;
case 4: list.traverse(); break;
case 5: System.out.println("Exiting..."); break;
default: System.out.println("Invalid.");
}
} while (choice != 5);
scanner.close();
}}
