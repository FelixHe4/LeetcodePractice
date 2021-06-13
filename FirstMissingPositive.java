
public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			if (nums[i] <= 0 || nums[i] > n) {
				nums[i] = n + 1;
			}
		}
		for (int i = 0; i < n; ++i) {
			int cur = nums[i];
			if (cur > n)
				continue;
			--cur;
			if (nums[cur] > 0) {
				nums[cur] *= -1;
			}
		}
		for (int i = 0; i < n; ++i) {
			if (nums[i] >= 0) {
				return i + 1;
			}
		}
		return -1;
	}
}
