package No1672;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
	public int maximumWealth(int[][] accounts) {
		int maxAssets = 0;
		for (int assets = 0; assets < accounts.length; assets++) {
			int assetsSum = 0;
			for (int i = 0; i < accounts[assets].length; i++) {
				assetsSum = assetsSum + accounts[assets][i];
			}
			if (maxAssets < assetsSum) {
				maxAssets = assetsSum;
			}
		}
		return maxAssets;
	}

	public int maximumWealth_byJava8(int[][] accounts) {
		return Arrays.stream(accounts)
			.map(Arrays::stream)
			.mapToInt(IntStream::sum)
			.max()
			.orElse(0);
	}

	public static void main(String[] args) {
		int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
		int maximumWealth = new Solution().maximumWealth_byJava8(accounts);
		System.out.println(maximumWealth);
	}
}
