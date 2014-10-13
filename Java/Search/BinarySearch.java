package Search;

@SuppressWarnings("all")
public class BinarySearch 
{
	public static boolean binarySearch(Comparable[] a, Comparable value)
	{
		return binarySearch(a, value, 0, a.length - 1);
	}
	private static boolean binarySearch(Comparable[] a, Comparable value,
			int lo, int hi) 
	{
		if (hi < lo)
			return false;
		int mid = (lo + hi) / 2;
		int cmp = a[mid].compareTo(value);
		if (cmp == 0)
			return true;
		else if (cmp < 0)
			return binarySearch(a, value, mid + 1, hi);
		else 
			return binarySearch(a, value, lo, mid - 1);
	}
	public static void main(String[] args)
	{
		Integer[] a = {4,5,6,7,8,9};
		System.out.println(binarySearch(a, 4));
	}
}
