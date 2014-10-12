package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class ActivityScheduling implements Comparable<ActivityScheduling>
{
	int start;
	int end;
	public ActivityScheduling(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	public int compareTo(ActivityScheduling b)
	{
		return end - b.end;
	}
	public String toString()
	{
		return start + " " + end;
	}

	public static ArrayList<ActivityScheduling> schedule(ActivityScheduling[] activities)
	{
		if (activities == null || activities.length < 1)
			return null;
		Arrays.sort(activities);
		ArrayList<ActivityScheduling> list = new ArrayList<ActivityScheduling>();
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
		ActivityScheduling[] a = new ActivityScheduling[6];
		a[0] = new ActivityScheduling(1, 2);
		a[1] = new ActivityScheduling(3, 4);
		a[2] = new ActivityScheduling(0, 6);
		a[3] = new ActivityScheduling(5, 7);
		a[4] = new ActivityScheduling(8, 9);
		a[5] = new ActivityScheduling(5, 9);
		ArrayList<ActivityScheduling> list = schedule(a);
		for (ActivityScheduling ac:list)
		{
			System.out.println(ac);
		}
	}
}
