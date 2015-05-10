import java.util.Arrays;

// May 7, 2015
// Interview Question 1.7 page 73

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its
 * entire row and column are set to 0.
 */

public class SetZero_1_7 {
	public void setZeros(int[][] input) {
		boolean[] row = new boolean[input.length];
		boolean[] col = new boolean[input[0].length];
		
		for (int i=0; i<input.length; i++) {
			for (int j=0; j<input[0].length; j++) {
				if(input[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for (int i=0; i<input.length; i++) {
			for (int j=0; j<input[0].length; j++) {
				if(row[i]||col[j]) {
					input[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[][] input = {{1,2,3}, {4,0,5}, {6,7,0}};
		SetZero_1_7 test = new SetZero_1_7();
		System.out.println(Arrays.deepToString(input));
		test.setZeros(input);
		System.out.println(Arrays.deepToString(input));
	}
}
