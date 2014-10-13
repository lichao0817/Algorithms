package Sort;

//5:59
//5:37
//5:13
@SuppressWarnings("all")
public class MergeSort {
	public static void mergeSort(Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) 
	{
		if (hi <= lo)
			return;
		int mid = (lo + hi) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, hi);
	}
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int hi) 
	{
		int mid = (lo + hi) / 2;
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++)
		{
			aux[k] = a[k]; 
		}
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid)						{	a[k] = aux[j++];	}
			else if (j > hi)					{	a[k] = aux[i++];	}
			else if (aux[i].compareTo(aux[j]) < 0)	{	a[k] = aux[i++];	}
			else 									{	a[k] = aux[j++];	}
		}
	}
	public static void main(String[] args)
	{
		String[] a = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", 
				"s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", 
				"b", "n", "m"};
		mergeSort(a);
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
