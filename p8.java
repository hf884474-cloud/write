import java.util.Scanner;
public class p8 {
static Scanner sc = new Scanner(System.in);
static int maxSize = 10;
static int[] stack = new int[maxSize];
static int top = -1;
public static void main(String[] args) {
System.out.print("How many elements to push? ");
int count = sc.nextInt();
pushMultiple(count);
display();
}
public static void pushMultiple(int count) {
for (int i = 0; i < count; i++) {
if (top >= maxSize - 1) {
System.out.println("Overflow Error: Stack is full!");
return;
}
System.out.print("Enter value to push: ");
int value = sc.nextInt();
top++;
stack[top] = value;
}
}
public static void display() {
if (top == -1) {
System.out.println("Underflow: Stack is empty.");
return;
}
System.out.print("Stack elements (bottom to top): ");
for (int i = 0; i <= top; i++) {
System.out.print(stack[i] + " ");
}
System.out.println();
}
}
