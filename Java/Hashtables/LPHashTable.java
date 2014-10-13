package Hashtables;

import java.util.ArrayList;

public class LPHashTable<Key, Value> 
{
	private static final int INIT_CAPACITY = 4;
	private int M;
	private int N;
	private Key[] keys;
	private Value[] vals;
	
	public LPHashTable()
	{
		this(INIT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public LPHashTable (int capacity)
	{
		M = capacity;
		N = 0;
		keys = (Key[]) new Object[M];
		vals = (Value[]) new Object[M];
	}

	private int hash(Key key)
	{
		return (key.hashCode() & Integer.MAX_VALUE) % M;
	}
	
	private void put(Key key, Value val)
	{
		if (val == null)
		{
			delete(key);
		}
		if (N > M/2)
			resize(M*2);
		int i;
		for (i = hash(key); keys[i] != null; i = (i + 1) % M)
		{
			if (key.equals(keys[i]))
			{
				vals[i] = val;
				return;
			}
		}
		keys[i] = key;
		vals[i] = val;
		N++;
	}
	
	private void resize(int capacity) 
	{
		LPHashTable<Key, Value> tmp = new LPHashTable<Key, Value>(capacity);
		for (int i = 0; i < M; i++) 
		{
			if (keys[i] != null)
				tmp.put(keys[i], vals[i]);
		}
		M = tmp.M;
		keys = tmp.keys;
		vals = tmp.vals;
	}
	
	public Value get(Key key)
	{
		for (int i = hash(key); keys[i] != null; i = (i + 1) % M)
		{
			if (keys[i].equals(key))
			{
				return vals[i];
			}
		}
		return null;
	}
	
	public void delete(Key key) 
	{
		if (!contains(key))
			return;
		int i = hash(key);
		while (!key.equals(keys[i]))
		{
			i = (i + 1) % M;
		}
		keys[i] = null;
		vals[i] = null;
		
		i = (i + 1) % M;
		
		while (keys[i] != null)
		{
			Key keyToRehash = keys[i];
			Value valToRehash = vals[i];
			keys[i] = null;
			vals[i] = null;
			N--;
			put(keyToRehash, valToRehash);
			i = (i + 1) % M;
		}
		
		N--;
		
		if (N > 0 && N < M/8)
		{
			resize(M/2);
		}
		
		
	}
	
	public boolean contains(Key key)
	{
		if (get(key) != null)
			return true;
		return false;
	}
	
	public Iterable<Key> getKeys()
	{
		ArrayList<Key> queue = new ArrayList<Key>();
		for (int i = 0; i < M; i++)
		{
			if (keys[i] != null)
			{
				queue.add(keys[i]);;
			}
		}
		return queue;
	}

	public int size()
	{
		return N;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	
	public static void main(String[] args)
	{
		LPHashTable<String, Integer> st = new LPHashTable<String, Integer>();
		st.put("abc", 1);
		st.put("bcd", 2);
		st.put("def", 3);
		
		for (Object s:st.getKeys())
		{
			System.out.println((String)s + " " + st.get((String)s)); 
		}
	}
}
