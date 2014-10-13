package Tree;

import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import com.sun.corba.se.impl.oa.poa.ActiveObjectMap.Key;

public class RedBlackBST <Value extends Comparable<Value>>
{
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	private int N;
	
	private class Node
	{
		private Value val;
		private Node left, right;
		private boolean color;
		public Node (Value val, boolean color)
		{
			this.val = val;
			this.color = color;
		}
	}
	
	public Value get(Value val)
	{
		return get(root, val);
	}

	private Value get(Node node, Value val) 
	{
		while (node != null)
		{
			int cmp = val.compareTo(node.val);
			if (cmp < 0) 
			{
				node = node.left;
			}
			else if (cmp > 0) 
			{
				node = node.right;
			}
			else
			{
				return node.val;
			}
		}
		return null;
	}
	
	public boolean contains(Value val)
	{
		return get(val) != null;
	}
	
	public void put(Value val)
	{
		root = insert(root, val);
		root.color = BLACK;
	}

	private Node insert(Node node, Value val) 
	{
		if (node == null)
		{
			N++;
			return new Node(val, RED);
		}
		
		int cmp = val.compareTo(node.val);
		if (cmp < 0)
		{
			node.left = insert(node.left, val);
		}
		else if (cmp > 0)
		{
			node.right = insert(node.right, val);
		}
		
		if (isRed(node.right) && !isRed(node.left))
		{
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left))
		{
			node = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right))
		{
			flipColors(node);
		}
		
		return node;
	}
	private void flipColors(Node node) 
	{
		node.color = RED;
		node.left.color = BLACK;
		node.right.color = BLACK;
	}

	private Node rotateRight(Node node) 
	{
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}

	private Node rotateLeft(Node node) 
	{
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}

	public int size()
	{
		return this.N;
	}
	
	private boolean isRed(Node x)
	{
		if (x == null)
			return false;
		return x.color == RED;
	} 
}
