import java.io.IOException;
import java.util.PriorityQueue;

public class MinimumNumberOfGasStations {

	public static class Pair implements Comparable<Pair> {
		int pos, gas;

		public Pair(int pos, int gas) {
			this.pos = pos;
			this.gas = gas;
		}

		public int compareTo(Pair o) {
			return o.gas - gas;
		}
	}

	public static int minRefuelStops(int target, int startFuel, int[][] stations) {
		int position = startFuel;
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
		int stops = 0;
		int count = 0;
		while (position < target) {
			for (int i = count; i < stations.length; ++i) {
				if (stations[i][0] <= position) {
					pq.add(new Pair(stations[i][0], stations[i][1]));
					++count;
				} else break;
			}
			if (!pq.isEmpty())
				position += pq.poll().gas;
			else return -1;
			++stops;
		}
		return stops;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(minRefuelStops(100, 50, new int[][] { { 25, 25 }, { 50, 50 } }));
	}
}
