package No1480;

import java.util.Arrays;

public class RunningSumOf1dArray {
	/**
	 * recommended
	 */
	public int[] solution(int[] nums) {
		int previous = 0; // (1)
		final int[] result = new int[nums.length]; // (2)
		for (int i = 0; i < nums.length; i++) {
			previous = previous + nums[i];
			result[i] = previous;
		}
		return result;
	}

	public int[] solution1(int[] nums) {
		for (int i = 0; i < nums.length; i++) { // (1)
			if (i != 0) {
				nums[i] = nums[i - 1] + nums[i]; // (2)
			}
		}
		return nums; // (3)
	}


	public int[] solution2(int[] nums) {
		final int[] previous = {0};
		return Arrays.stream(nums) // (1)
			.peek(i -> previous[0] = i + previous[0]) // (2)
			.map(i -> previous[0]) // (3)
			.toArray(); // (4)
	}

}
