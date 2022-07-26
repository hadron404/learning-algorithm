package No383;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) { // (1)
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		magazine.chars().forEach(i -> map.merge(i, 1, Integer::sum));  // (2)
		return ransomNote.chars().noneMatch(i -> { // (3)
			Integer count = map.get(i);
			if (count == null || count == 0) {
				return true;
			}
			map.put(i, count - 1);
			return false;
		});
	}

	public boolean canConstruct1(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) { // (1)
			return false;
		}
		char base = 'a';
		int[] count = new int[26];
		for (char c : magazine.toCharArray()) { // (2)
			count[c - base]++;
		}
		return ransomNote.chars()
			.map(i -> { // (3)
				count[i - base]--;
				return count[i - base];
			})
			.noneMatch(i -> i < 0); // (4)
	}

	public boolean canConstruct2(String ransomNote, String magazine) {
		if (ransomNote.length() > magazine.length()) { // (1)
			return false;
		}
		char base = 'a';
		int[] count = new int[26];  // (2)
		for (char c : magazine.toCharArray()) {
			count[c - base]++; // (3)
		}
		for (char c : ransomNote.toCharArray()) {
			count[c - base]--;  // (4)
			if (count[c - base] < 0) {  // (5)
				return false;
			}
		}
		return true;
	}
}
