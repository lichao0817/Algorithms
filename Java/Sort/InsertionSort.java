package Sort;

@SuppressWarnings("all")
public class InsertionSort 
{
	public static void insertionSort(Comparable[] a)
	{
		for (int i = 0; i < a.length; i++) {
			Comparable c = a[i];
			int j = i - 1;
			while (j >= 0 && a[j].compareTo(c) > 0)
			{
				a[j + 1] = a[j];
				j--;
			}
			a[j+1] = c;
		}
	}
	
	public static void main(String[] args)
	{
		Integer[] a = {2,3,4,5,1};
		insertionSort(a);
		for (int i = 0; i < a.length; i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
}
