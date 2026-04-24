import java.util.Scanner;
class BinarySearcher {
public void sort(int[] arr, int n) {
for (int i = 0; i < n - 1; i++) {
for (int j = 0; j < n - i - 1; j++) {
if (arr[j] > arr[j + 1]) {
int temp = arr[j];
arr[j] = arr[j + 1];
arr[j + 1] = temp;
}
}
}
}
public void findAll(int[] arr, int n, int target) {
int low = 0;
int high = n - 1;
int firstIdx = -1;
while (low <= high) {
int mid = low + (high - low) / 2;
if (arr[mid] == target) {
firstIdx = mid;
break;
}
if (arr[mid] < target) {
low = mid + 1;
} else {
high = mid - 1;
}
}
if (firstIdx == -1) {
System.out.println("Element not found.");
return;
}
System.out.print("Indices found: ");
int left = firstIdx;
while (left >= 0 && arr[left] == target) {
left--;
}
for (int i = left + 1; i < n && arr[i] == target; i++) {
System.out.print(i + " ");
}
System.out.println();
}
}
public class p19 {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
BinarySearcher bSearch = new BinarySearcher();
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
bSearch.sort(numbers, n);
System.out.print("Sorted array: [");
for (int i = 0; i < n; i++) {
System.out.print(numbers[i]);
if (i < n - 1) {
System.out.print(", ");
}
}
System.out.println("]");
System.out.print("Enter value to find: ");
int target = sc.nextInt();
bSearch.findAll(numbers, n, target);
sc.close();
}
}
