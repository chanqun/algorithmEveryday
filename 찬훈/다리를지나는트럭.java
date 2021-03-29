package solution;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Solution {
	class Truck {
		int weight;
		int entry;

		Truck(int weight, int entry) {
			this.weight = weight;
			this.entry = entry;
		}
	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Truck> waiting = new LinkedList<>();
		Queue<Truck> bridge = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; i++) {
			waiting.add(new Truck(truck_weights[i], 0));
		}
		
		int time = 0;
		int totalWeight = 0;
		
		while(!waiting.isEmpty() || !bridge.isEmpty()) {
			time++;
			if(!bridge.isEmpty()) {
				Truck t = bridge.element();
				if(time - t.entry >= bridge_length) {
					totalWeight -= t.weight;
					bridge.remove();
				}
			}
			
			if(!waiting.isEmpty()) {
				if(totalWeight + waiting.element().weight <= weight) {
					Truck t = waiting.remove();
					totalWeight += t.weight;
					
					bridge.add(new Truck(t.weight, time));
				}
			}
		}
		
		return time;
	}
}