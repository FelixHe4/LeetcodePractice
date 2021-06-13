import java.io.IOException;

public class FindDuplicateNumber {

	public static void main(String[] args) throws IOException {
		System.out.println(findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
	}

	public static int findDuplicate(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < n; ++i) {
			int cur = Math.abs(nums[i]);
			--cur;
			if (nums[cur] >= 0) {
				nums[cur] *= -1;
			} else {
				return cur;
			}
		}
		return -1;
	}
}
