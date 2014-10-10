package Heap;

public class BinaryHeap <Value extends Comparable<Value>>
{
	private final static int INIT_SIZE = 8;
	private int size;
	private int capacity;
	private Value[] vals;
	
	public BinaryHeap()
	{
		this(INIT_SIZE);
	}
	public BinaryHeap(int capacity)
	{
		this.capacity = capacity;
		vals = (Value[]) new Comparable[capacity];
		size = 0;
	}
	
	private void resize(int capacity)
	{
		Value[] tmp = (Value[]) new Object[capacity];
		for (int i = 0; i < vals.length; i++)
		{
			tmp[i] = vals[i];
		}
		vals = tmp;
		this.capacity = capacity;
	}
	
	public void insert(Value value)
	{
		if (size > capacity/2)
		{
			resize(capacity*2);
		}
		vals[++size] = value;
		swim(size);
	}
	private void swim(int index) 
	{
		if (index <= 1)
		{
			return;
		}
		int parent = index / 2;
		if (vals[index].compareTo(vals[parent]) > 0)
		{
			exchange(index, parent);
			swim(parent);
		}
	}
	
	public Value removeMax()
	{
		if (size < 1)
		{
			return null;
		}
		Value v = vals[1];
		vals[1] = vals[size];
		vals[size] = null;
		size--;
		promote(1);
		if (size < capacity/4)
		{
			resize(capacity/2);
		}
		return v;
	}
	
	public int size()
	{
		return this.size;
	}
	
	public boolean isEmpty()
	{
		return this.size == 0;
	}
	
	private void promote(int index) 
	{
		if (size == 0)
			return;
		int leftChild = index * 2;
		int rightChild = index * 2 + 1;
		if (vals[leftChild] != null && vals[index].compareTo(vals[leftChild]) < 0)
		{
			if (vals[rightChild] == null || vals[leftChild].compareTo(vals[rightChild]) >= 0)
			{
				exchange(index, leftChild);
				promote(leftChild);
			}
		}
		if (vals[rightChild] != null && vals[index].compareTo(vals[rightChild]) < 0)
		{
			if (vals[leftChild] == null || vals[rightChild].compareTo(vals[leftChild]) >= 0)
			{
				exchange(index, rightChild);
				promote(rightChild);
			}
		}
	}
	private void exchange(int i, int j)
	{
		Value v = vals[i];
		vals[i] = vals[j];
		vals[j] = v;
	}
	
	public void traversal()
	{
		for (int i = 1; i <= size; i++)
		{
			System.out.print(vals[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		BinaryHeap<Integer> heap = new BinaryHeap<Integer>();
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.traversal();
		heap.removeMax();
		heap.traversal();
	}
}
