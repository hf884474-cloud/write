import java.util.Scanner;
class IntStack {
int top = -1;
int[] items;
IntStack(int size) {
items = new int[size];
}
void push(int val) {
if (top < items.length - 1) {
items[++top] = val;
}
}
int pop() {
if (top == -1) return -1;
return items[top--];
}
boolean isEmpty() {
return top == -1;
}
}
public class p15 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter Postfix Expression: ");
String P = sc.nextLine();
IntStack stack = new IntStack(P.length());
for (int i = 0; i < P.length(); i++) {
char c = P.charAt(i);
if (c == ' ') continue;
if (Character.isDigit(c)) {
stack.push(c - '0');
} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^') {
if (stack.isEmpty()) {
System.out.println("Unexpected operator: " + c);
return;
}
int val2 = stack.pop();
if (stack.isEmpty()) {
System.out.println("Unexpected operator: " + c);
return;
}
int val1 = stack.pop();
switch (c) {
case '+': stack.push(val1 + val2); break;
case '-': stack.push(val1 - val2); break;
case '*': stack.push(val1 * val2); break;
case '/': 
if(val2 == 0) {
System.out.println("Division by zero!");
return;
}
stack.push(val1 / val2); break;
case '^': stack.push((int) Math.pow(val1, val2)); break;
}
} else {
System.out.println("Invalid character " );
return;
}
}
if (stack.isEmpty()) {
System.out.println("Empty expression");
return;
}
int result = stack.pop();
if (!stack.isEmpty()) {
System.out.println("Unexpected operand remaining");
} else {
System.out.println("Final Evaluation Result: " + result);
}
sc.close();
}
}
