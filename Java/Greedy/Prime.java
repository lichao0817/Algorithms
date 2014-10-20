package Greedy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import Graph.Edge;
import Graph.Graph;
import Heap.MinHeap;

public class Prime 
{
	private Graph graph;
	private List<Edge> mst;
	
	public Prime(Graph graph)
	{
		this.graph = graph;
	}
	
	private List<Edge> mst()
	{
		MinHeap<Edge> heap = new MinHeap<Edge>();
		HashSet<Integer> include = new HashSet<Integer>();
		HashSet<Integer> exclude = new HashSet<Integer>();
		List<Edge> mst = new LinkedList<Edge>();
		for (int i = 1; i < graph.adjencyList().length; i++)
		{
			exclude.add(i);
		}
		include.add(0);
		for (Edge e:graph.adjencyList()[0])
		{
			heap.insert(e);
		}
		while (!heap.isEmpty())
		{
			Edge edge = heap.removeMin();
			if (include.contains(edge.start) && exclude.contains(edge.end))
			{
				mst.add(edge);
				include.add(edge.end);
				exclude.remove(edge.end);
				for (Edge e:graph.adjencyList()[edge.end])
				{
					heap.insert(e);
				}
			}
		}
		return mst;
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
		Prime prime = new Prime(graph);
		prime.print();
	}
}
