package Union_Find;

public class UnionFind 
{
	//The index of the parent node
	private int[] parents;
	//The size of each chunk
	private int[] sizes;
	//The number of disjoint chunks
	private int count;
	
	public UnionFind(int number)
	{
		count = number;
		parents = new int[number];
		sizes = new int[number];
		for (int i = 0; i < number; i++)
		{
			parents[i] = i;
			sizes[i] = 1;
		}
	}
	
	public int count()
	{
		return count;
	}
	
	private int parent(int p)
	{
		int parent = p;
		while(parent != parents[parent])
			parent = parents[parent];
		while (p != parent)
		{
			int tmp = parents[p];
			parents[p] = parent;
			p = tmp;
		}
		return parent;
	}
	
	public boolean connected(int p, int q)
	{
		return parent(p) == parent(q);
	}
	
	public void union(int p, int q)
	{
		int parentP = parent(p);
		int parentQ = parent(q);
		
		if (parentP == parentQ)
			return;
		
		if (sizes[parentP] >= sizes[parentQ])
		{
			sizes[parentP] += sizes[parentQ];
			parents[parentQ] = parentP;
		}
		else
		{
			sizes[parentQ] += sizes[parentP];
			parents[parentP] = parentQ;
		}
		count--;
	}
	
	public static void main(String[] args)
	{
		UnionFind unionFind = new UnionFind(5);
		unionFind.union(0, 1);
		unionFind.union(1, 2);
		unionFind.union(3, 4);
		unionFind.union(2, 3);
		
		System.out.println(unionFind.connected(0, 4));
		System.out.println(unionFind.connected(1, 3));
	}
}
