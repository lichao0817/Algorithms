package Question;

import java.util.HashSet;
import java.util.Stack;

public class Questions 
{
	String a = "aaa";
	public static boolean isSubString(String str, String find)
	{
		if (find.length() > str.length())
		{
			return false;
		}
		if (find == str || (str.length() == 0 && find.length() == 0))
		{
			return true;
		}
		
		for (int i = 0; i < str.length(); i++)
		{
			boolean foundNonMatch = false;
			for (int j = 0; j < find.length(); j++)
			{
				if (str.charAt(j+i) != find.charAt(j))
				{
					foundNonMatch = true;
					break;
				}
			}
			if (!foundNonMatch)
			{
				return true;
			}
		}
		
		return false;
	}
	
	public class DoubleLinkedListNode
	{
		int data;
		DoubleLinkedListNode previous;
		DoubleLinkedListNode next;
		public DoubleLinkedListNode(int data)
		{
			this.data = data;
		}
	}
	
	public static void remove (DoubleLinkedListNode head, int data)
	{
		DoubleLinkedListNode node = head;
		while (node != null)
		{
			if (node.data == data)
			{
				if (node.previous != null)
					node.previous.next = node.next;
				if (node.next != null)
					node.next.previous = node.previous;
				node.previous = null;
				node.next = null;
				return;
			}
			node = node.next;
		}
	}
	
	public static boolean isValid(BinaryTreeNode head)
	{
		if (head == null)
		{
			return true;
		}
		return isValid(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isValid(BinaryTreeNode head, int min, int max)
	{
		if (head.left != null)
		{
			if (head.left.value < min || !isValid(head.left, min, head.value))
			{
				return false;
			}
		}
		if (head.right != null)
		{
			if (head.right.value > max || !isValid(head.right, head.value, max))
			{
				return false;
			}
		}
		return true;
	}
	
	public static int odd(int[] a)
	{
		HashSet<Integer> set = new HashSet<Integer>();
		int sum = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (set.contains(a[i]))
				sum -= a[i];
			else
			{
				set.add(a[i]);
				sum += a[i];
			}
		}
		return sum;
	}

	public static void main(String[] args)
	{
		Questions questions = new Questions();
		System.out.println(questions.a);
	}
}
