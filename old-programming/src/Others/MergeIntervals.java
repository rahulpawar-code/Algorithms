/*
 * Problem Statement:
 * Given a set of time intervals in any order, merge all overlapping intervals into one
 * and output the result which should have only mutually exclusive intervals. Let the
 * intervals be represented as pairs of integers for simplicity.
 * 
 * Link: https://www.geeksforgeeks.org/merging-intervals/
 */

package Others;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

class Interval{
	int start;
	int end;
	
	public Interval(int s, int e) {
		start = s;
		end = e;
	}
	
	public boolean isOverlapping(Interval i) {
		return this.end >= i.start;
	}
	
	public void mergeIntervals(Interval i) {
		start = Math.min(start, i.start);
		end = Math.max(end, i.end);
	}
	
	public void printInterval() {
		System.out.print("{" + start + "," + end + "}");
	}
}

public class MergeIntervals {
	private static void printIntervalList(List<Interval> intervals) {
		for (Interval i : intervals) {
			i.printInterval();
			System.out.print(" ");
		}
		System.out.println("");
	}
	
	// O(nlonn) time and inplace merge
	private static void mergeIntervalInplace(List<Interval> intervals) {
		if (intervals == null) {
			throw new IllegalArgumentException("null interval list");
		}
		
		// Sort in descending order
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o2.start - o1.start;
			}
		});
		
		// Start from 2nd index, remove original elements and add merged elements
		// Size of list changes dynamically so keep track of it
		int index = 1;
		int listSize = intervals.size();
		while (index < listSize) {
			Interval previous = intervals.get(index - 1);
			Interval current = intervals.get(index);
			if (current.isOverlapping(previous)) {
				current.mergeIntervals(previous);
				intervals.remove(previous);
				listSize = intervals.size();
			} else {
				index++;
			}
		}
	}
	
	// O(nlogn) time and O(n) space 
	private static void mergeIntervalWithStack(List<Interval> intervals) {
		if (intervals == null) {
			throw new IllegalArgumentException("null intervals");
		}
		
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		
		Stack<Interval> stack = new Stack<>();
		stack.push(intervals.get(0));
		for (int i = 1; i < intervals.size(); ++i) {
			Interval top = stack.peek();
			Interval next = intervals.get(i);
			if (top.isOverlapping(next)) {
				top.mergeIntervals(next);
				stack.pop();
				stack.push(top);
			} else {
				stack.push(next);
			}
		}
		
		while (!stack.isEmpty()) {
			Interval top = stack.pop();
			System.out.print("(" + top.start + "," + top.end + ") ");
		}
		System.out.println("");
	}
	
	// O(n^2) complexity
	private static void mergeIntervalsMethod1(List<Interval> intervals) {
		if (intervals == null) {
			throw new IllegalArgumentException("null argument");
		}
		
		for (int i = 0; i < intervals.size(); ++i) {
			for (int j = intervals.size() - 1; j > i; --j) {
				Interval a = intervals.get(i);
				Interval b = intervals.get(j);
				if (a.isOverlapping(b)) {
					a.mergeIntervals(b);
					intervals.remove(j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Interval> intervals = new LinkedList<>();
		intervals.add(new Interval(4,7));
		intervals.add(new Interval(6,8));
		intervals.add(new Interval(1,9));
		intervals.add(new Interval(2,4)); 
		intervals.add(new Interval(20,40));
		
		mergeIntervalsMethod1(intervals);
		printIntervalList(intervals);
		
		List<Interval> intervals2 = new LinkedList<>();
		intervals2.add(new Interval(4,7));
		intervals2.add(new Interval(6,8));
		intervals2.add(new Interval(1,9));
		intervals2.add(new Interval(2,4)); 
		intervals2.add(new Interval(20,40));
		
		mergeIntervalWithStack(intervals2);
		
		List<Interval> intervals3 = new LinkedList<>();
		intervals3.add(new Interval(4,7));
		intervals3.add(new Interval(6,8));
		intervals3.add(new Interval(1,9));
		intervals3.add(new Interval(2,4)); 
		intervals3.add(new Interval(20,40));
		intervals3.add(new Interval(30,50));
		
		mergeIntervalInplace(intervals3);
		printIntervalList(intervals3);
	}
}