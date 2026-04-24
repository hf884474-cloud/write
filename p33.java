import java.util.Scanner;

public class p33 {
    private static final int MAXN = 10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        if (n > MAXN) {
            System.out.println("Overflow error");
            sc.close();
            return;
        } else if (n <= 0) {
            System.out.println("Underflow error");
            sc.close();
            return;
        }
        int[] arr = new int[MAXN];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("\nOriginal Array: ");
        printArray(arr, n);        
        radixSort(arr, n);
        System.out.print("Sorted Array:   ");
        printArray(arr, n);    
        sc.close();
    }
    public static void radixSort(int[] arr, int n) {
        // Find max using only the 'n' filled slots
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, n, exp);
        }
    }
    private static void countingSort(int[] arr, int n, int exp) {
        int[] output = new int[n]; 
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
    public static void printArray(int[] arr, int n) {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
