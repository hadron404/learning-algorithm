package No1342;

public class Solution {

	public int numberOfSteps(int num) {
		return calculate(num, 0);
	}

	public int calculate(int num, int step) {
		if (num == 0) {
			return step;
		}
		if (num % 2 == 0) {
			return calculate(num / 2,++step);
		}
		return calculate(num - 1, ++step);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numberOfSteps(14));
	}
}
