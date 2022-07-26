package No383;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Integer, Integer> map = new HashMap<>();
		magazine.chars().forEach(i -> map.merge(i, 1, Integer::sum));
		return ransomNote.chars().noneMatch(i -> {
			Integer value = map.get(i);
			if (value != null && value != 0) {
				map.put(i, value - 1);
			}
			return value == null || value == 0;
		});
	}
}
