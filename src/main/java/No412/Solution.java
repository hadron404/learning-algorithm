package No412;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

	private static final String FIZZ = "Fizz";
	private static final String BUZZ = "Buzz";
	private static final String FIZZ_BUZZ = FIZZ + BUZZ;

	/**
	 * 执行用时： 1ms 内存消耗 42.1
	 */
	public static List<String> fizzBuzz(int n) {
		List<String> answer = new ArrayList<>(n);
		for (int i = 1; i <= n; i++) {
			answer.add(convert(i));
		}
		return answer;
	}


	/**
	 * 执行用时： 2ms 内存消耗 42.1
	 */
	public static List<String> fizzBuzz2(int n) {
		return IntStream.range(1, n + 1)
			.mapToObj(Solution::convert)
			.collect(Collectors.toList());
	}

	public List<String> fizzBuzz3(int n) {
		List<String> answer = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			answer.add(convert2(i).toString());
		}
		return answer;
	}

	private static StringBuilder convert2(int i) {
		StringBuilder sb = new StringBuilder();
		if (i % 3 == 0) {
			sb.append(FIZZ);
		}
		if (i % 5 == 0) {
			sb.append(BUZZ);
		}
		if (sb.length() == 0) {
			sb.append(i);
		}
		return sb;
	}

	public static String convert(int i) {
		if (i % 15 == 0) {
			return FIZZ_BUZZ;
		}
		if (i % 3 == 0) {
			return FIZZ;
		}
		if (i % 5 == 0) {
			return BUZZ;
		} else {
			return i + "";
		}

	}
}
