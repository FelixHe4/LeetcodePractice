import java.io.IOException;

public class LongestSubarraySum {

	public static void main(String[] args) throws IOException {
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		int[] arr = { -5, 6, -2, 4, 6, 1, 3, -3, 9, 7, -8, -10 };
		for (int i : arr) {
			max_ending_here = (max_ending_here + i) < 0 ? max_ending_here : max_ending_here + i;
			max_so_far = Math.max(max_so_far, max_ending_here);
		}
		System.out.println(max_so_far);
	}
}
