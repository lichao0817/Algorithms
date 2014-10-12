package Heap;

@SuppressWarnings("all")
public class MinHeap <Value extends Comparable<Value>>
{
	private static final int INIT_CAPACITY = 8;
	private Value[] vals;
	private int capacity;
	private int size;
	
	public MinHeap()
	{
		this(INIT_CAPACITY);
	}

	public MinHeap(int capacity) 
	{
		this.capacity = capacity;
		size = 0;
		vals = (Value[]) new Comparable[capacity + 1];
	}
	
	private void resize(int capacity)
	{
		Value[] tmp = (Value[]) new Comparable[capacity + 1];
		this.capacity = capacity;
		for (int i = 0; i <= size; i++)
		{
			tmp[i] = vals[i];
		}
		vals = tmp;
	}
	
	public void insert(Value value)
	{
		if (value != null)
		{	
			vals[++size] = value;
			swim(size);
		}
		if (size > capacity / 2)
		{
			resize(capacity * 2);
		}
	}

	private void swim(int i) 
	{
		int parent = i / 2;
		if (parent > 0)
		{
			if (vals[i].compareTo(vals[parent]) < 0)
			{
				exchange(i, parent);
				swim(parent);
			}
		}
	}
	
	private void exchange(int i, int j)
	{
		Value value = vals[i];
		vals[i] = vals[j];
		vals[j] = value;
	}
	
	public Value removeMin()
	{
		if (size > 0)
		{
			exchange(1, size);
			Value value = vals[size];
			vals[size--] = null;
			move(1);
			if (size < capacity/4)
				resize(capacity/2);
			return value;
		}
		return null;
	}

	private void move(int i) 
	{
		int left = 2 * i;
		int right = 2 * i + 1;
		if (right <= size)
		{
			int min = min(left, right);
			if (vals[i].compareTo(vals[min]) > 0)
			{
				exchange(i, min(left, right));
				move(min);
			}
		}
		else if (left <= size)
		{
			if (vals[i].compareTo(vals[left]) > 0)
			{
				exchange(i, left);
				move(left);
			}
		}
	}
	
	private int min(int i, int j)
	{
		return vals[i].compareTo(vals[j]) < 0? i:j;
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
		MinHeap<Integer> heap = new MinHeap<Integer>();
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.traversal();
		heap.removeMin();
		heap.traversal();
		heap.removeMin();
		heap.traversal();
	}
}
