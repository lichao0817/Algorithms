package Tree;

public class BinarySearchTree <Value extends Comparable<Value>>
{
	private Node head;
	
	private class Node
	{
		Node leftChild;
		Node rightChild;
		Value value;
		
		public Node(Value value)
		{
			this.value = value;
		}
	}
	public void put(Value value)
	{
		if (value == null)
		{
			return;
		}
		head = put(head, value);
		
	}
	public Node put(Node head, Value value)
	{
		if (head == null)
		{
			return new Node(value);
		}
		int cmp = value.compareTo(head.value);
		if (cmp < 0)
		{
			head.leftChild = put(head.leftChild, value);
		}
		else
		{
			head.rightChild = put(head.rightChild, value);
		}
		return head;
	}
	
	public void delete(Value value)
	{
		if (value != null)
			head = delete(head, value);
	}
	
	public Node delete(Node node,Value value)
	{
		if (node == null)
		{
			return null;
		}
		int cmp = value.compareTo(node.value);
		if (cmp < 0)
		{
			node.leftChild = delete(node.leftChild, value);
			return node;
		}
		else if (cmp > 0)
		{
			node.rightChild = delete(node.rightChild, value);
			return node;
		}
		else
		{
			if (node.leftChild == null)
				return node.rightChild;
			if (node.rightChild == null)
				return node.leftChild;
			Value small = min(node.rightChild);
			node.value = small;
			node.rightChild = delete(node.rightChild, small);
			return node;
		}
	}
	
	private Value min(Node node)
	{
		if (node.leftChild != null)
			return min(node.leftChild);
		return node.value;
	}
	public void inOrderTraversal()
	{
		inOrderTraversal(head);
		System.out.println();
	}
	private void inOrderTraversal(Node node)
	{
		if (node == null)
			return;
		inOrderTraversal(node.leftChild);
		System.out.print(node.value + " ");
		inOrderTraversal(node.rightChild);
	}
	
	public void preorderTraversal(Node node)
	{
		if (node == null)
			return;
		System.out.println(node.value + " ");
		preorderTraversal(node.leftChild);
		preorderTraversal(node.rightChild);
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree<Integer> t = new BinarySearchTree<Integer>();
		t.put(5);
		t.put(4);
		t.put(6);
		t.put(1);
		t.put(7);
		t.inOrderTraversal();
		System.out.println("After Removal: ");
		t.delete(5);
		t.inOrderTraversal();
	}
}
