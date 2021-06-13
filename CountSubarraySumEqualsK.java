import java.io.IOException;
import java.util.HashMap;

public class CountSubarraySumEqualsK {

	public static void main(String[] args) throws IOException {
		int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int k = 0;
		int sum = 0, count = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; ++i) {
			sum += nums[i];
			if (sum == k) {
				++count;
			}
			if (hm.containsKey(sum - k)) {
				count += hm.get(sum - k);
			}
			if (hm.containsKey(sum)) {
				hm.put(sum, hm.get(sum) + 1);
			} else {
				hm.put(sum, 1);
			}
		}
		System.out.println(count);
	}

}
