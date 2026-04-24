import java.util.Scanner;

class StackData {
    static final int MAXSIZE = 25;
    static int[] arr = new int[MAXSIZE];
    static int top = -1;
}

class StackOperations {
    public static void create(Scanner sc) {
        StackData.top = -1; 
        System.out.print("Enter number of initial elements: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Unserflow error");
        } else if (n > StackData.MAXSIZE) {
            System.out.println("Overflow error!");
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter value " + (i + 1) + ": ");
                StackData.top++;
                StackData.arr[StackData.top] = sc.nextInt();
            }
            System.out.println("Stack created with " + n + " elements.");
        }
    }

    public static void push(Scanner sc) {
        char continuePush = 'y';
        while (continuePush == 'y' || continuePush == 'Y') {
            if (StackData.top == StackData.MAXSIZE - 1) {
                System.out.println("Overflow!");
                break;
            }
            System.out.print("Enter value: ");
            StackData.top++;
            StackData.arr[StackData.top] = sc.nextInt();
            
            System.out.print("Do you want to push more? (y/n): ");
            continuePush = sc.next().charAt(0);
        }
    }

    public static void pop(Scanner sc) {
        char continuePop = 'y';
        while (continuePop == 'y' || continuePop == 'Y') {
            if (StackData.top == -1) {
                System.out.println("Underflow!");
                break;
            }
            System.out.println("Popped: " + StackData.arr[StackData.top]);
            StackData.top--;

            if (StackData.top == -1) {
                System.out.println("Stack is now empty.");
                break;
            }

            System.out.print("Do you want to pop more? (y/n): ");
            continuePop = sc.next().charAt(0);
        }
    }

    public static void traverse() {
        if (StackData.top == -1) {
            System.out.println("Stack is empty.");
        } else {
            System.out.println("--- Stack (Top to Bottom) ---");
            for (int i = StackData.top; i >= 0; i--) {
                System.out.println("| " + StackData.arr[i] + " |");
            }
            System.out.println("-------");
        }
    }
}

public class p10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("\n1.Create 2.Push 3.Pop 4.Traverse 5.Exit");
            System.out.print("Choice: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        StackOperations.create(sc); // Passed sc here
                        break;
                    case 2:
                        StackOperations.push(sc);
                        break;
                    case 3:
                        StackOperations.pop(sc);
                        break;
                    case 4:
                        StackOperations.traverse();
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } else {
                System.out.println("Please enter a valid number.");
                sc.next(); 
            }
        }
        sc.close();
    }
}
