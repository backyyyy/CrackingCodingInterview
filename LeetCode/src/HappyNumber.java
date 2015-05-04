import java.util.HashSet;

// May 3, 2015

/**
 * Write an algorithm to determine if a number is "happy". A happy number is a
 * number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the
 * process until the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1. Those numbers for which this process
 * ends in 1 are happy numbers.
 * 
 * Example: 19 is a happy number 
 * 1^2 + 9^2 = 82 
 * 8^2 + 2^2 = 68 
 * 6^2 + 8^2 = 100 
 * 1^2 + 0^2 + 0^2 = 1
 */

public class HappyNumber {
	public boolean isHappy(int n) {
		int[] hash = new int[1000];
		for (int i = 0; i < 1000; i++) {
			hash[i] = 0;
		}

		int m = n;
		boolean flag = false;
		while (true) {
			m = getSum(m);
			if (m == 1) {
				flag = true;
				break;
			} else if (hash[m] == 1 || m == n) {
				break;
			}
			hash[m] = 1;
		}
		return flag;
	}

	public int getSum(int n) {
		int sum = 0;
		while (n > 0) {
			int t = n % 10;
			sum += t * t;
			n /= 10;
		}
		return sum;
	}
	
	public boolean isHappy2(int n) {
		if (n == 1) return true;
		if (n == 0) return false;
		HashSet<Integer> sets = new HashSet<Integer>();
		
		int num = n;
		while (num != 1) {
			if(sets.contains(num)) return false;
			int sum = 0;
			sets.add(num);
			
			while (num != 0) {
				double tmp = (double) num;
				sum += Math.pow(tmp, 2);
				num /= 10;
			}
			num = sum;
		}
		
		if (num == 1) return true;
		else return false;
	}

	public static void main(String[] args) {
		int input = 56;
		HappyNumber test = new HappyNumber();
		System.out.println(test.isHappy(input));
		System.out.println(test.isHappy2(input));
	}
}
