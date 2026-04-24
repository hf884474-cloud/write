import java.util.Scanner;

public class p6 {
static Scanner sc = new Scanner(System.in);
static int[] arr = new int[100]; 
static int n; 

public static void main(String[] args) {
input();
System.out.print("Array before: ");
display();
deleteOne();
System.out.print("Final Array: ");
display();
}

public static void input() {
System.out.print("Enter number of elements ");
n = sc.nextInt();
if (n < 1 || n > 100) {
System.out.println("Invalid size. Terminating program.");
System.exit(0); 
}
System.out.println("Enter " + n + " elements:");
for (int i = 0; i < n; i++) {
arr[i] = sc.nextInt();
}
}

public static void deleteOne() {
if (n == 0) {
System.out.println("Underflow: Array is empty.");
return;
}
System.out.print("Enter index to delete ");
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
} else {                                                  
System.out.println("Exiting");
}
}

public static void display() {
if (n == 0) {
System.out.println("Array is empty.");
return;
}
for (int i = 0; i < n; i++) {
System.out.print(arr[i] + " ");
}
System.out.println();
}
}
