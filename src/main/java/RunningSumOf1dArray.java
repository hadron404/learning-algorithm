import java.util.Arrays;

public class RunningSumOf1dArray {
	public int[] solution(int[] nums) {
		final int[] previous = {0};
		return Arrays.stream(nums)
			.map(i -> {
				previous[0] = i + previous[0];
				return previous[0];
			})
			.toArray();
	}


	public int[] solution2(int[] nums) {
		final int[] previous = {0};
		return Arrays.stream(nums)
			.map(i -> {
				previous[0] = i + previous[0];
				return previous[0];
			})
			.toArray();
	}

}
