import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) throws IOException {
		int[] nums = { 2, 7, 9, 11 };
		int target = 9;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int[] ans = new int[2];
		int count = 0;
		for (int i : nums) {
			if (hm.containsKey(target - i)) {
				ans[1] = count;
				ans[0] = hm.get(target - i);
				System.out.println(Arrays.toString(ans));
				return;
			} else {
				hm.put(i, count);
			}
			++count;
		}
		System.out.println(Arrays.toString(ans));
	}
}
