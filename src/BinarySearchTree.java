public class BinarySearchTree
{
	Node root;

	public void inOrderTraversal(Node focusNode)
	{
		if (focusNode != null)
		{
			inOrderTraversal(focusNode.leftChild);
			System.out.print(focusNode.data + " - ");
			inOrderTraversal(focusNode.rightChild);
		}
	}

	//
	// Insertion
	//

	public void insert(int value)
	{
		if (root == null)
		{
			root = new Node(value);
		}
		else
		{
			insertNode(root, value);
		}
	}

	private void insertNode(Node focusNode, int value)
	{
		if (value < focusNode.data)
		{
			if (focusNode.leftChild == null)
			{
				focusNode.leftChild = new Node(value);
				focusNode.leftChild.parent = focusNode;
			}
			else
			{
				insertNode(focusNode.leftChild, value);
			}
		}
		else
		{
			if (focusNode.rightChild == null)
			{
				focusNode.rightChild = new Node(value);
				focusNode.rightChild.parent = focusNode;
			}
			else
			{
				insertNode(focusNode.rightChild, value);
			}
		}
	}

	//
	// Searching
	//

	public boolean searchNode(Node focusNode, int value)
	{
		if (focusNode == null)
		{
			return false;
		}

		if (focusNode.data == value)
		{
			return true;
		}
		else if (value < focusNode.data)
		{
			return searchNode(focusNode.leftChild, value);
		}
		else
		{
			return searchNode(focusNode.rightChild, value);
		}
	}

	//
	// Deletion
	//

	public boolean deleteNode(int value)
	{
		Node nodeToBeDeleted = find(value);

		if (nodeToBeDeleted != null)
		{
			// Case # 1: node is a leaf
			if (nodeToBeDeleted.leftChild == null
					&& nodeToBeDeleted.rightChild == null)
			{
				if (nodeToBeDeleted.data == root.data)
				{
					root = null;
				}
				else if (nodeToBeDeleted.data < nodeToBeDeleted.parent.data)
				{
					nodeToBeDeleted.parent.leftChild = null;
				}
				else
				{
					nodeToBeDeleted.parent.rightChild = null;
				}
			}
			// Case # 2: node has a left child
			else if (nodeToBeDeleted.leftChild != null
					&& nodeToBeDeleted.rightChild == null)
			{
				if (nodeToBeDeleted.data < nodeToBeDeleted.parent.data)
				{
					nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.leftChild;
				}
				else
				{
					nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.leftChild;
				}
			}
			// Case # 3: node has a right child
			else if (nodeToBeDeleted.leftChild == null
					&& nodeToBeDeleted.rightChild != null)
			{
				if (nodeToBeDeleted.data < nodeToBeDeleted.parent.data)
				{
					nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.rightChild;
				}
				else
				{
					nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.rightChild;
				}
			}
			// Case # 4: node have both left and right children
			else
			{
				Node largestValue = nodeToBeDeleted.leftChild;

				if (nodeToBeDeleted.leftChild.leftChild != null
						&& nodeToBeDeleted.leftChild.rightChild != null)
				{
					while (largestValue.rightChild != null)
					{
						largestValue = largestValue.rightChild;
					}

					largestValue.parent.rightChild = null;
					nodeToBeDeleted.data = largestValue.data;
				}
				else if (nodeToBeDeleted.leftChild.leftChild == null
						&& nodeToBeDeleted.leftChild.rightChild == null)
				{
					nodeToBeDeleted.data = largestValue.data;
					nodeToBeDeleted.leftChild = null;
				}
			}
			return true;
		}
		return false;
	}

	private Node find(int value)
	{
		if (root != null)
		{
			return findNode(root, value);
		}

		return null;
	}

	private Node findNode(Node focusNode, int value)
	{
		if (focusNode == null)
		{
			return null;
		}

		if (focusNode.data == value)
		{
			return focusNode;
		}
		else
		{
			Node match;
			if (value < focusNode.data)
			{
				match = findNode(focusNode.leftChild, value);
			}
			else
			{
				match = findNode(focusNode.rightChild, value);
			}

			return match;
		}
	}
}
