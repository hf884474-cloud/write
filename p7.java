import java.util.Scanner;

public class p7 {
static Scanner sc = new Scanner(System.in);
static int[] arr = new int[100];
static int n = 0;

public static void main(String[] args) {
int choice;
while (true) {
System.out.println("\n---MENU ---");
System.out.println("1. Create Array");
System.out.println("2. Insert");
System.out.println("3. Delete");
System.out.println("4. Traverse ");
System.out.println("5. Search Element");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");

if (!sc.hasNextInt()) {
System.out.println("Invalid input. Enter a number.");
sc.next(); 
continue;
}

choice = sc.nextInt();

switch (choice) {
case 1: create(); break;
case 2: insertOne(); break;
case 3: deleteOne(); break;
case 4: traverse(); break;
case 5: search(); break;
case 6: System.exit(0);
default: System.out.println("Invalid choice!");
}
}
}

public static void create() {
System.out.print("Enter number of elements to add: ");
int count = sc.nextInt();
if (count > 100 || count < 0) {
System.out.println("Error: Limit is 0-100.");
return;
}
n = count;
System.out.println("Enter " + n + " elements:");
for (int i = 0; i < n; i++) {
arr[i] = sc.nextInt();
}
}

public static void insertOne() {
if (n >= 100) {
System.out.println("Overflow: Array is full.");
return;
}
System.out.print("Enter index to insert at: ");
int pos = sc.nextInt();
if (pos < 0 || pos > n) {
System.out.println("Invalid position.");
} else {
System.out.print("Enter value to insert: ");
int val = sc.nextInt();
for (int i = n - 1; i >= pos; i--) {
arr[i + 1] = arr[i];
}
arr[pos] = val;
n++;
System.out.println("Element inserted.");
}
System.out.println("Do you want to insert more? (Y/N)");
sc.nextLine(); 
String choice = sc.nextLine();
if (choice.equalsIgnoreCase("Y")) {
insertOne();
}
}

public static void deleteOne() {
if (n == 0) {
System.out.println("Underflow: Array is empty.");
return;
}
System.out.print("Enter index to delete: ");
int pos = sc.nextInt();
if (pos < 0 || pos >= n) {
System.out.println("Invalid position.");
} else {
for (int i = pos; i < n - 1; i++) {
arr[i] = arr[i + 1];
}
n--;
System.out.println("Element deleted.");
}
System.out.println("Do you want to delete more? (Y/N)");
sc.nextLine(); 
String choice = sc.nextLine();
if (choice.equalsIgnoreCase("Y")) {
deleteOne();
}
}

public static void traverse() {
if (n == 0) {
System.out.println("Array is empty.");
return;
}
System.out.print("Array: ");
for (int i = 0; i < n; i++) {
System.out.print(arr[i] + " ");
}
System.out.println();
}

public static void search() {
System.out.print("Enter element to search: ");
int target = sc.nextInt();
boolean found = false;
for (int i = 0; i < n; i++) {
if (arr[i] == target) {
System.out.println("Found at index: " + i);
found = true;
}
}
if (!found) System.out.println("Not found.");
}
}
