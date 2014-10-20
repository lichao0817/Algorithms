package Divide_Conquer;

public class Inversion 
{
	public static int sortCount(Comparable[] a)
	{
		if (a == null || a.length < 2)
			return 0;
		Comparable[] aux = new Comparable[a.length];
		return sortCount(a, aux, 0, a.length - 1);
	}
	private static int sortCount(Comparable[] a, Comparable[] aux, int lo, int hi) 
	{
		if (hi <= lo)
			return 0;
		int mid = (lo + hi) / 2;
		int left = sortCount(a, aux, lo, mid);
		int right = sortCount(a, aux, mid+1, hi);
		int merge = mergeCount(a, aux, lo, hi);
		return left + right + merge;
	}
	private static int mergeCount(Comparable[] a, Comparable[] aux, int lo,
			int hi) 
	{
		int count = 0;
		int mid = (lo + hi) / 2;
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid)							{	a[k] = aux[j++];	}
			else if (j > hi)						{	a[k] = aux[i++];	}
			else if (aux[i].compareTo(aux[j]) < 0)	{	a[k] = aux[i++];	}
			else 									
			{	
				a[k] = aux[j++];
				count += mid - i + 1;	
			}
		}
		return count;
	}
	public static void main(String[] args)
	{
		Integer[] a = {2, 4, 1, 3, 5};
		System.out.println(sortCount(a));
	}
}
