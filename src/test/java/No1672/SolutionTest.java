package No1672;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

	@Test
	void maximumWealth() {
		int[][] accounts = {{1, 2, 3}, {3, 2, 1}};
		int maximumWealth = new Solution().maximumWealth(accounts);
		Assertions.assertEquals(6, maximumWealth);
	}
}
