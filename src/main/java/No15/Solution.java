package No15;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {


	/**
	 * 超出时间限制
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		// 存放找到的三元组，并借助map结构去重
		// key = 三元组的数组索引（按顺序排列）
		Map<String, List<Integer>> result = new HashMap<>();
		for (int ia = 0; ia < nums.length; ia++) {
			int a = nums[ia];
			for (int ib = 0; ib < nums.length; ib++) {
				if (ia == ib) {
					continue;
				}
				int b = nums[ib];
				for (int ic = 0; ic < nums.length; ic++) {
					if (ib == ic || ic == ia) {
						continue;
					}
					int c = nums[ic];
					if (a + b + c == 0) {
						String key = Stream.of(a, b, c)
							.map(Math::abs)
							.sorted()
							.map(Object::toString)
							.collect(Collectors.joining(""));
						result.put(key, List.of(a, b, c));
					}
				}
			}
		}
		return new ArrayList<>(result.values());
	}

	/**
	 * 通用解决方案NSum
	 * 从int数组nums中，找出所有不重复的n个数的组合(n>=2)，使得这n个数的和为target
	 */
	public List<List<Integer>> commonSum(int[] nums, int n, int target) {
		if (nums == null || nums.length < n) {
			return new ArrayList<>();
		} else {
			Arrays.sort(nums);
			if (n == 2) {
				return twoSum(nums, 0, target);
			} else {
				return nSum(nums, 0, n, target);
			}
		}
	}

	// 本题的解答：3Sum问题
	public List<List<Integer>> threeSum2(int[] nums) {
		if (nums == null || nums.length < 3) {
			return new ArrayList<>();
		} else {
			Arrays.sort(nums);
			return nSum(nums, 0, 3, 0);
		}
	}

	// 从有序数组nums中，找出所有不重复的2个数的组合，使得这2个数的和为target
	public List<List<Integer>> twoSum(int[] nums, int start, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		int p = start, q = nums.length - 1;
		int left, right, sum;
		int half = target >> 1;
		while (p < q) {
			left = nums[p];
			if (left > half) break;

			right = nums[q];
			if (right < half) break;

			sum = left + right;
			if (sum > target) {
				q--;
				while (p < q && nums[q] == right) q--;
			} else if (sum < target) {
				p++;
				while (p < q && nums[p] == left) p++;
			} else {
				List<Integer> item = new ArrayList<>();
				item.add(left);
				item.add(right);
				ans.add(item);
				p++;
				while (p < q && nums[p] == left) p++;
				q--;
				while (p < q && nums[q] == right) q--;
			}
		}
		return ans;
	}

	// 从有序数组nums中，找出所有不重复的n个数的组合(n>=2)，使得这n个数的和为target
	public List<List<Integer>> nSum(int[] nums, int start, int n, int target) {
		if (n == 2) {
			return twoSum(nums, start, target);
		}
		List<List<Integer>> ans = new ArrayList<>();
		int tail = nums.length - n;
		int i = start, first;
		while (i <= tail) {
			//选择nums[i]作为第一个元素，并将i++
			first = nums[i++];
			// 子问题，从first右侧的数中找n-1个，使得其和为target-first
			List<List<Integer>> list = nSum(nums, i, n - 1, target - first);
			for (List<Integer> item : list) {
				item.add(first);
			}
			ans.addAll(list);
			//跳过重复的元素，
			while (i <= tail && nums[i] == first) i++;
		}
		return ans;
	}
}
