import java.util.Scanner;
public class P3 {
static void sortArray(int[] arr, int n) {
for (int i = 0; i < n - 1; i++) {
for (int j = i + 1; j < n; j++) {
if (arr[i] > arr[j]) {
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}}}}
static int[] mergeArrays(int[] arr1, int n1, int[] arr2, int n2) {
if (n1 + n2 > 20) {
System.out.println("Array is large");
return null;
}
int[] merged = new int[n1 + n2];
int i = 0, j = 0, k = 0;
while (i < n1 && j < n2) {
if (arr1[i] <= arr2[j]) {
merged[k++] = arr1[i++];
} else {
merged[k++] = arr2[j++];
}}
while (i < n1) {
merged[k++] = arr1[i++];
}
while (j < n2) {
merged[k++] = arr2[j++];
}
return merged;
}
static void printArray(int[] arr, int n) {
for (int i = 0; i < n; i++) {
System.out.print(arr[i] + " ");
}
System.out.println();
}
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int max = 10;
System.out.print("size of first array: ");
int n1 = sc.nextInt();
int[] arr1 = new int[n1];
System.out.print("size of second array: ");
int n2 = sc.nextInt();
int[] arr2 = new int[n2];
if (n1 > max || n2 > max) {
System.out.println("Size greater than capacity");
return;
}
if (n1 <= 0 || n2 <= 0 ) {
System.out.println("Underflow error");
return;
}
System.out.println("Enter elements of first array:");
for (int i = 0; i < n1; i++) {
arr1[i] = sc.nextInt();
}
System.out.println("Enter elements of second array:");
for (int i = 0; i < n2; i++) {
arr2[i] = sc.nextInt();
}
sortArray(arr1, n1);
sortArray(arr2, n2);
System.out.println("Sorted Array 1:");
printArray(arr1, n1);
System.out.println("Sorted Array 2:");
printArray(arr2, n2);
int[] arr3 = mergeArrays(arr1, n1, arr2, n2);
if (arr3 != null) {
System.out.println("Merged Sorted Array :");
printArray(arr3, arr3.length);
}
}}
