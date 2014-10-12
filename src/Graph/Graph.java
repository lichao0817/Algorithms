package Graph;

public class Graph 
{
	private int V;
	private int E;
	private Edge[] edges;
	private int count;
	
	public Graph (int V, int E)
	{
		this.V = V;
		this.E = E;
		edges = new Edge[E];
		count = 0;
	}
	
	public int V()
	{
		return V;
	}
	
	public int E()
	{
		return E;
	}
	
	public void add(Edge e)
	{
		if (count < E)
			edges[count++] = e;
	}
	
	public Edge[] edges()
	{
		return edges;
	}
}
