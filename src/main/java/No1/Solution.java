package No1;

import java.util.HashMap;
import java.util.Objects;

public class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
			int first = nums[firstIndex];
			int secondTarget = target - first;
			for (int secondIndex = 0; secondIndex < nums.length; secondIndex++) {
				if (firstIndex == secondIndex) {
					continue;
				}
				if (secondTarget == nums[secondIndex]) {
					result[0] = firstIndex;
					result[1] = secondIndex;
					return result;
				}
			}
		}
		return result;
	}

	public int[] twoSum2(int[] nums, int target) {
		int[] result = new int[2];
		HashMap<Integer, Integer> indexMap = new HashMap<>();
		HashMap<Integer, Integer> secondMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int secondNum = target - nums[i];
			secondMap.put(i, secondNum);
			indexMap.put(nums[i], i);
		}
		secondMap.forEach((firstNumIndex, secondNum) -> {
			Integer secondNumIndex = indexMap.get(secondNum);
			if (Objects.equals(firstNumIndex, secondNumIndex)) {
				return;
			}
			if (secondNumIndex != null) {
				result[0] = firstNumIndex;
				result[1] = secondNumIndex;
			}
		});
		return result;
	}

	public int[] twoSum3(int[] nums, int target) {
		HashMap<Integer, Integer> indexMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (indexMap.containsKey(target - nums[i])) {
				return new int[]{indexMap.get(target - nums[i]), i};
			}
			indexMap.put(nums[i], i);
		}
		return new int[0];
	}

}
