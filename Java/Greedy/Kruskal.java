package Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import Graph.Edge;
import Graph.Graph;
import Union_Find.UnionFind;

public class Kruskal 
{
	private UnionFind unionFind;
	private Graph graph;
	private List<Edge> mst;
	public Kruskal(Graph graph)
	{
		this.graph = graph;
		unionFind = new UnionFind(graph.V());
	}
	
	private List<Edge> mst()
	{
		List<Edge> list = new LinkedList<Edge>();
		Edge[] edges = graph.edges();
		Arrays.sort(edges);
		for (int i = 0; i < edges.length; i++)
		{
			Edge edge = edges[i];
			if (!unionFind.connected(edge.start, edge.end))
			{
				list.add(edge);
				unionFind.union(edge.start, edge.end);
			}
		}
		
		return list;
	}
	
	public void print()
	{
		if (mst == null)
			mst = mst();
		for (int i = 0; i < mst.size(); i++)
		{
			System.out.println(mst.get(i).start + " -- " + mst.get(i).end + " == " + mst.get(i).weight);
		}
	}
	
	public static void main(String[] args)
	{
		Graph graph = new Graph(4, 5);
		graph.add(new Edge(0, 1, 10));
		graph.add(new Edge(0, 2, 6));
		graph.add(new Edge(0, 3, 5));
		graph.add(new Edge(1, 3, 15));
		graph.add(new Edge(2, 3, 4));
		Kruskal kruskal = new Kruskal(graph);
		kruskal.print();
	}
}
