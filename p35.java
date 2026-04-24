import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

public class TreeMenu {
    static Scanner sc = new Scanner(System.in);
    Node root = null;

    // Recursive method to build tree using Yes/No questions
    public Node buildTree() {
        System.out.print("Enter node value: ");
        int value = sc.nextInt();
        Node newNode = new Node(value);

        System.out.print("Add LEFT child for " + value + "? (y/n): ");
        if (sc.next().equalsIgnoreCase("y")) {
            newNode.left = buildTree();
        }

        System.out.print("Add RIGHT child for " + value + "? (y/n): ");
        if (sc.next().equalsIgnoreCase("y")) {
            newNode.right = buildTree();
        }

        return newNode;
    }

    public int countNodes(Node node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public boolean search(Node node, int target) {
        if (node == null) return false;
        if (node.data == target) return true;
        return search(node.left, target) || search(node.right, target);
    }

    public static void main(String[] args) {
        TreeMenu menu = new TreeMenu();
        int choice;

        while (true) {
            System.out.println("\n--- BINARY TREE MENU ---");
            System.out.println("1. Create/Rebuild Tree");
            System.out.println("2. Count Total Nodes");
            System.out.println("3. Search for a Node");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Starting tree construction...");
                    menu.root = menu.buildTree();
                    System.out.println("Tree built successfully!");
                    break;

                case 2:
                    if (menu.root == null) {
                        System.out.println("Tree is empty. Create it first!");
                    } else {
                        System.out.println("Total Nodes: " + menu.countNodes(menu.root));
                    }
                    break;

                case 3:
                    if (menu.root == null) {
                        System.out.println("Tree is empty. Create it first!");
                    } else {
                        System.out.print("Enter value to search: ");
                        int val = sc.nextInt();
                        if (menu.search(menu.root, val)) {
                            System.out.println("Found: Node " + val + " exists.");
                        } else {
                            System.out.println("Not Found: Node " + val + " does not exist.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
