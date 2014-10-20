package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph 
{
	private int V;
	private int E;
	private Edge[] edges;
	private int count;
	private HashSet<Edge>[] adjencyList;
	
	public Graph (int V, int E)
	{
		this.V = V;
		this.E = E;
		edges = new Edge[E];
		count = 0;
		adjencyList = (HashSet<Edge>[])new HashSet[V];
		for (int i = 0; i < adjencyList.length; i++)
		{
			adjencyList[i] = new HashSet<Edge>();
		}
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
		{	
			edges[count++] = e;
			adjencyList[e.start].add(new Edge(e.start, e.end, e.weight));
			adjencyList[e.end].add(new Edge(e.end, e.start, e.weight));
		}
		
	}
	
	public HashSet<Edge> edgeList(int i)
	{
		return adjencyList[i];
	}
	
	public Edge[] edges()
	{
		return edges;
	}
	
	public HashSet<Edge>[] adjencyList()
	{
		return adjencyList;
	}
	
	public static void main(String[] args)
	{
		List<Integer> list = new ArrayList<Integer>();
		Integer[] a = (Integer[])list.toArray();
		
	}
}
