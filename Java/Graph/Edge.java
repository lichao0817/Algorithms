package Graph;

public class Edge implements Comparable<Edge>
{
	public int start;
	public int end;
	public int weight;
	public Edge(int start, int end, int weight)
	{
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Edge b)
	{
		if (weight > b.weight)
			return 1;
		else if (weight < b.weight)
			return -1;
		return 0;
	}
	
	public String toString()
	{
		return start + " -- " + end + " == " + weight;
	}
}
