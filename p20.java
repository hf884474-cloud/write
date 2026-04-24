import java.util.Scanner;
class SelectionSorter {
public void sort(int[] arr, int n) {
for (int i = 0; i < n - 1; i++) {
int minIndex = i;
for (int j = i + 1; j < n; j++) {
if (arr[j] < arr[minIndex]) {
minIndex = j;
}
}
int temp = arr[minIndex];
arr[minIndex] = arr[i];
arr[i] = temp;
}
}
public void printArray(int[] arr, int n) {
for (int i = 0; i < n; i++) {
System.out.print(arr[i]);
if (i < n - 1) {
System.out.print(", ");
}
}
System.out.println();
}
}
public class p20 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
SelectionSorter sorter = new SelectionSorter();
int[] numbers = new int[10];
System.out.print("Enter number of elements (max 10): ");
int n = sc.nextInt();
if (n > 10 || n < 1) {
System.out.println("Invalid size.");
return;
}
System.out.println("Enter " + n + " numbers:");
for (int i = 0; i < n; i++) {
numbers[i] = sc.nextInt();
}
System.out.print("Original list: ");
sorter.printArray(numbers, n);
sorter.sort(numbers, n);
System.out.print("Sorted list:   ");
sorter.printArray(numbers, n);
}
}
