import java.util.Scanner;
class Searcher {
public boolean findAllIndices(int[] arr, int size, int target) {
boolean found = false;
System.out.print("Indices found: ");
for (int i = 0; i < size; i++) {
if (arr[i] == target) {
System.out.print(i + " ");
found = true;
}
}
System.out.println();
return found;
}
}
public class p18 {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
Searcher searcher = new Searcher();
int[] numbers = new int[10];
System.out.print("Enter number of elements (1-10): ");
int n = scanner.nextInt();
if (n > 10 || n < 1) {
System.out.println("Error: Size must be between 1 and 10.");
return;
}
System.out.println("Enter " + n + " numbers:");
for (int i = 0; i < n; i++) {
numbers[i] = scanner.nextInt();
}
System.out.print("Enter search target: ");
int target = scanner.nextInt();
boolean wasFound = searcher.findAllIndices(numbers, n, target);
if (!wasFound) {
System.out.println("Element not found in the list.");
}
}
}
