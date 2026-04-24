import java.util.Scanner;

public class p34 {
    private static final int MAXN = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        if (n > MAXN) {
            System.out.println("Overflow error ");
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
        
        shellSort(arr, n);

        System.out.print("Sorted Array:   ");
        printArray(arr, n);
        
        sc.close();
    }

    public static void shellSort(int[] arr, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
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
