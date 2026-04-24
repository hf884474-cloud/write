import java.util.Scanner;
class MyStack {
int top = -1;
char[] items;
MyStack(int size) {
items = new char[size + 1]; 
}
void push(char c) {
if (top < items.length - 1) {
items[++top] = c;
}
}
char pop() {
if (top == -1) return '0';
return items[top--];
}
char peek() {
if (top == -1) return '0';
return items[top];
}
boolean isEmpty() {
return top == -1;
}
}
public class p14 {
static int getPriority(char op) {
if (op == '+' || op == '-') return 1;
if (op == '*' || op == '/') return 2;
if (op == '^') return 3;
return 0;
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Enter Infix Expression (Q): ");
String Q = sc.nextLine();
MyStack stack = new MyStack(Q.length() + 1);
String P = "";
boolean expectOperand = true;
for (int i = 0; i < Q.length(); i++) {
char element = Q.charAt(i);
if (element == ' ') continue;
if (Character.isLetterOrDigit(element)) {
if (!expectOperand) {
System.out.println("Unexpected operand: " + element);
return;
}
P = P + element;
expectOperand = false;
} else if (element == '(') {
if (!expectOperand) {
System.out.println("Unexpected parenthesis: (");
return;
}
stack.push(element);
expectOperand = true;
} else if (element == ')') {
if (expectOperand) {
System.out.println("Unexpected parenthesis: )");
return;
}
while (!stack.isEmpty() && stack.peek() != '(') {
P = P + stack.pop();
}
stack.pop(); 
expectOperand = false;
} else if (element == '+' || element == '-' || element == '*' || element == '/' || element == '^') {
if (expectOperand) {
System.out.println("Unexpected operator: " + element);
return;
}
while (!stack.isEmpty() && stack.peek() != '(' && getPriority(stack.peek()) >= getPriority(element)) {
P = P + stack.pop();
}
stack.push(element);
expectOperand = true;
}
}
if (expectOperand && Q.length() > 0) {
System.out.println("Incomplete expression");
return;
}
while (!stack.isEmpty()) {
P = P + stack.pop();
}
System.out.println("Postfix Expression (P): " + P);
sc.close();
}
}
