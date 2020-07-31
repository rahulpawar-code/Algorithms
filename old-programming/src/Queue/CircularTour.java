package Queue;

public class CircularTour {
	static private class PetrolPump {
		int petrol;
		int distance;
		
		public PetrolPump(int p, int d) {
			petrol = p;
			distance = d;
		}
	}

	static int getCircularTour(PetrolPump[] stations) {
		if (stations == null) {
			return -1;
		}
		int n = stations.length;
		int start = 0;
		int end = 1;
		int current = stations[start].petrol - stations[end].distance;
		
		while (end != start || current < 0) {
			while (current < 0 && start != end) {
				current -= stations[start].petrol - stations[start].distance;
				start = (start + 1) % n;
				
				if (start == 0) {
					return -1;
				}
			}
			
			// Enqueue end
			current += stations[end].petrol - stations[end].distance;
			end = (end + 1) % n;
		}
		
		
		return start;
	}
	
	public static void main(String[] args) {
		PetrolPump[] stations = {new PetrolPump(6, 4), 
                new PetrolPump(3, 6), 
                new PetrolPump(7, 3), new PetrolPump(4, 5)}; 
		int start = getCircularTour(stations);
		System.out.println(start);
	}

}
