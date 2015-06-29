import java.util.Scanner;

public class BST
{

	public static void main(String[] args)
	{
		BinarySearchTree tree = new BinarySearchTree();
		boolean exit = false;
		int choice;
		int input;
		boolean searchResult;

		Scanner scan = new Scanner(System.in);

		while (exit == false)
		{
			System.out.println("[1] Insert");
			System.out.println("[2] Search");
			System.out.println("[3] Delete");
			System.out.println("[4] Exit");

			choice = scan.nextInt();

			if (choice == 1)
			{
				System.out.print("[INSERT] Enter an integer: ");

				input = scan.nextInt();

				tree.insert(input);

				System.out.println("Inorder Traversal: ");

				tree.inOrderTraversal(tree.root);

				System.out.println();
			}
			else if (choice == 2)
			{
				System.out.print("[SEARCH] Enter an integer: ");

				input = scan.nextInt();

				searchResult = tree.searchNode(tree.root, input);

				if (searchResult)
				{
					System.out.println("Item exists!");
				}
				else
				{
					System.out.println("Item not found.");
				}

				System.out.println();
				System.out.println("Inorder Traversal: ");

				tree.inOrderTraversal(tree.root);

				System.out.println();

			}
			else if (choice == 3)
			{
				System.out.print("[DELETE] Enter an integer: ");

				input = scan.nextInt();

				searchResult = tree.deleteNode(input);

				if (searchResult)
				{
					System.out.println("Item deleted!");
				}
				else
				{
					System.out.println("Item not found.");
				}

				System.out.println("Inorder Traversal: ");

				tree.inOrderTraversal(tree.root);

				System.out.println();

			}
			else if (choice == 4)
			{
				System.out.println();
				System.out.println("Goodbye!");
				System.out.println();

				exit = true;
			}
			else
			{
				System.out.println("Invalid Input!");
			}
		}
	}

}
