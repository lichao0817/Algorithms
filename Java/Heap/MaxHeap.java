package Heap;

@SuppressWarnings("all")
public class MaxHeap <Value extends Comparable<Value>>
{
	private static final int INIT_CAPACITY = 8;
	private Value[] vals;
	private int capacity;
	private int size;
	
	public MaxHeap()
	{
		this(INIT_CAPACITY);
	}
	public MaxHeap(int capacity)
	{
		this.capacity = capacity;
		vals = (Value[]) new Comparable[capacity+1]; 
		size = 0;
	}
	
	public void insert(Value value)
	{
		vals[++size] = value;
		swim(size);
		if (size >= capacity/2)
		{
			resize(capacity*2);
		}
	}
	
	public void swim(int i)
	{
		int parent = i / 2;
		if (i <= 1)
			return;
		if (vals[i].compareTo(vals[parent]) > 0)
		{
			exchange(i, parent);
			swim(parent);
		}
	}
	
	private void resize(int capacity) 
	{
		this.capacity = capacity;
		Value[] tmp = (Value[]) new Comparable[capacity];
		for (int i = 0; i < vals.length; i++)
		{
			tmp[i] = vals[i];
		}
		this.vals = tmp;
	}
	
	public Value removeMax()
	{
		exchange(1, size);
		Value value = vals[size];
		vals[size--] = null;
		move(1);
		return value;
	}
	
	private void move(int i) 
	{
		int left = i * 2;
		int right = i * 2 + 1;
		if (left <= size && right <= size)
		{
			int max = maxValue(left, right);
			if (vals[i].compareTo(vals[max]) < 0)
			{
				exchange(i, max);
				move(max);
			}
		}
		else if (left <= size)
		{
			if (vals[i].compareTo(vals[left]) < 0)
			{
				exchange(i, left);
				move(left);
			}
		}
	}
	
	private int maxValue(int i, int j)
	{
		return vals[i].compareTo(vals[j]) > 0? i:j;
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
		MaxHeap<Integer> heap = new MaxHeap<Integer>();
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.traversal();
		heap.removeMax();
		heap.traversal();
		heap.removeMax();
		heap.traversal();
	}
}
