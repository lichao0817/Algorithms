package Sort;

import java.util.Random;

//4:58
//4:18
//4:16
public class QuickSort 
{
	public static void shuffle(Comparable[] a)
	{
		Random random = new Random();
		for (int i = 0; i < a.length; i++)
		{
			int j = random.nextInt(a.length);
			if (j > i)
			{
				exchange(a, i, j);
			}
		}
	}
	public static void quickSort(Comparable[] a)
	{
		shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi)
	{
		if (hi <= lo)
		{
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	private static int partition(Comparable[] a, int lo, int hi) 
	{
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true)
		{
			while (a[++i].compareTo(v) < 0)
			{
				if (i == hi)
				{
					break;
				}
			}
			while (a[--j].compareTo(v) > 0)
			{
				if (j == lo)
				{
					break;
				}
			}
			if (j <= i)
			{
				break;
			}
			exchange(a, i, j);
		}
		exchange(a, lo, j);
		return j;
	}
	private static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static void main(String[] args) {
		String[] a = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", 
				"s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", 
				"b", "n", "m"};
		quickSort(a);
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
