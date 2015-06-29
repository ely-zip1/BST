
public class Node {
	
	int data;
	Node parent;
	Node leftChild;
	Node rightChild;
	
	public Node(int d){
		data = d;
		parent = null;
		leftChild = null;
		rightChild = null;
	}
	
	public Node(){
		data = 0;
		parent = null;
		leftChild = null;
		rightChild = null;
	}
	
}
