import java.io.IOException;
import java.util.HashMap;

public class LongestSubarraySumEqualsK {

	public static void main(String[] args) throws IOException {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] arr = { 1, 2, 3 };
		int sum = 0;
		int k = 3;
		for (int i = 0; i < arr.length; ++i) {
			sum += arr[i];
			if (sum == k) {
				hm.put(k, i);
			} else if (hm.containsKey(sum - k)) {
				hm.put(sum, i);
			}
		}
		System.out.println(hm.size());
	}
}
