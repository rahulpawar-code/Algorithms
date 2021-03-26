/*
 * Problem Link: https://www.careercup.com/question?id=5715298301247488
 */

package Greedy;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Box {
	Set<Integer> packets;
	int count;
	
	public Box() {
		packets = new HashSet<>();
		count = 0;
	}
	
	public void addPacket(int packet) {
		packets.add(packet);
		count += packet;
	}
	
	public void removePacket(int packet) {
		packets.remove(packet);
		count -= packet;
	}
}

public class ArrangePacketInBoxes {
	private static void arrangePacketsInBox(int numBoxes, int packets[]) {
		Comparator<Box> boxComparator = new Comparator<Box>() {
			public int compare(Box box0, Box box1) {
				return box0.count - box1.count;
			}
		};
		
		PriorityQueue<Box> queue = new PriorityQueue<>(boxComparator);
		for (int i = 0; i < numBoxes; ++i) {
			queue.add(new Box());
		}
		
		for (int i = 0; i < packets.length; ++i) {
			Box minBox = queue.poll();
			minBox.addPacket(packets[i]);
		}
	}
	
	public static void main(String[] args) {
		int numBoxes = 5;
		int packets[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 100};
		arrangePacketsInBox(numBoxes, packets);
	}
}
