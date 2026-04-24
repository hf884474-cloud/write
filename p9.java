import java.util.Scanner;

public class p9 {
    static Scanner sc = new Scanner(System.in);
    static final int Max = 100;
    static int[] stack = new int[Max];
    static int top = -1;

    public static void main(String args[]) {
        char choice;

        // --- Sequential Pushing ---
        System.out.println("Starting Push Operations:");
        do {
            push();
            if (top >= Max - 1) {
                System.out.println("Stack Full!");
                break;
            }
            System.out.print("Want to add another element? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');

        display();

        // --- Sequential Popping ---
        System.out.println("\nStarting Pop Operations:");
        do {
            if (top == -1) {
                System.out.println("Stack is now empty.");
                break;
            }
            pop();
            if (top == -1) break;

            System.out.print("Want to delete another element? (y/n): ");
            choice = sc.next().toLowerCase().charAt(0);
        } while (choice == 'y');

        display();
        System.out.println("\nFinal execution complete.");
    }

    public static void push() {
        if (top >= Max - 1) {
            System.out.println("Stack Overflow!");
        } else {
            System.out.print("Enter element to push: ");
            int val = sc.nextInt();
            top++;
            stack[top] = val;
            System.out.println(val + " pushed.");
        }
    }

    public static void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
        } else {
            int poppedVal = stack[top];
            top--;
            System.out.println("Popped element: " + poppedVal);
        }
    }

    public static void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.print("Current Stack: ");
            for (int i = top; i >= 0; i--) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
