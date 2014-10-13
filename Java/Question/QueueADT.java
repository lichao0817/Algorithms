package Question;

import java.util.Stack;

public class QueueADT <Value>
{
	private Stack<Value> in;
	private Stack<Value> out;
	
	public QueueADT()
	{
		in = new Stack<Value>();
		out = new Stack<Value>();
	}
	
	public void enqueue(Value val)
	{
		in.push(val);
	}
	public Value dequeue()
	{
		if (in.size() == 0 && out.size() == 0)
		{
			return null;
		}
		if (out.size() == 0)
		{
			while (in.size() != 0)
			{
				out.push(in.pop());
			}
		}
		return out.pop();
	}
	
	public static int[] maxSubArray(int[] a)
	{
		int [] subArray = null;
		if (a == null || a.length <= 1)
		{
			return a;
		}
		int start = 0;
		int end = 0;
		int sum = a[0];
		int curr = a[0];
		for (int i = 0; i < a.length; i++)
		{
			curr += a[i];
			if (curr > sum)
			{
				sum = curr;
				end = i;
			}
			if (a[i] >= sum)
			{
				sum = a[i];
				start = i;
				end = i;
				curr = a[i];
			}
		}
		System.out.println(start + " " + end);
		subArray = new int[end - start + 1];
		
		for (int i = start; i <= end; i++)
		{
			subArray[i - start] = a[i];
		}
		
		return subArray;
	}
	
	public static void main(String[] args)
	{
		int[] a = {0,0, 3, 0, -2, -9, -8, -6, -4};
		System.out.println(a.length);
		int[] sub = maxSubArray(a);
		for (int i = 0; i < sub.length; i++)
		{
			System.out.println(sub[i]);
		}
	}
}
