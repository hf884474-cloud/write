	import java.util.Scanner;
	class QuickSorter {
	public void sort(int[] arr, int low, int high) {
	if (low < high) {
	int pi = partition(arr, low, high);
	sort(arr, low, pi - 1);
	sort(arr, pi + 1, high);
	}
	}
	private int partition(int[] arr, int low, int high) {
	int pivot = arr[high];
	int i = (low - 1);
	for (int j = low; j < high; j++) {
	if (arr[j] < pivot) {
	i++;
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
	}
	}
	int temp = arr[i + 1];
	arr[i + 1] = arr[high];
	arr[high] = temp;
	return i + 1;
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
	public class p21 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	QuickSorter qs = new QuickSorter();
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
	qs.printArray(numbers, n);
	qs.sort(numbers, 0, n - 1);
	System.out.print("Sorted list:   ");
	qs.printArray(numbers, n);
	}
	}
