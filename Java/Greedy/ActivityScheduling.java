package Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ActivityScheduling
{
	public static List<Activity> schedule(Activity[] activities)
	{
		if (activities == null || activities.length < 1)
			return null;
		Arrays.sort(activities);
		List<Activity> list = new LinkedList<Activity>();
		list.add(activities[0]);
		for (int i = 1; i < activities.length; i++)
		{
			if (activities[i].start >= list.get(list.size() - 1).end)
			{
				list.add(activities[i]);
			}
		}
		return list;
	}
	
	public static void main(String[] args)
	{
		Activity[] a = new Activity[6];
		a[0] = new Activity(1, 2);
		a[1] = new Activity(3, 4);
		a[2] = new Activity(0, 6);
		a[3] = new Activity(5, 7);
		a[4] = new Activity(8, 9);
		a[5] = new Activity(5, 9);
		List<Activity> list = schedule(a);
		for (Activity ac:list)
		{
			System.out.println(ac);
		}
	}
}

class Activity implements Comparable<Activity>
{
	int start;
	int end;
	public Activity(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	public int compareTo(Activity b)
	{
		return end - b.end;
	}
	public String toString()
	{
		return start + " " + end;
	}
	
}