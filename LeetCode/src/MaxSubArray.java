// Jan 18, 2015

/**
 * Find the contiguous subarray within an array (containing 
 * at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest 
 * sum = 6. 
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding 
 * another solution using the divide and conquer approach, 
 * which is more subtle.
 */

public class MaxSubArray {
	public int maxSubArray(int[] A) {
		
		// Time Complexity: O(N);
		// Space Complexity: O(1);
		
        int sum = A[0];
        int max = A[0];

        for(int i=1; i<A.length; i++){
        	sum = Math.max(sum + A[i],A[i]);
        	max = Math.max(sum, max);
        }
        return max;
    }
	
//	public int maxSubArray2(int[] A){
//		
//	}
	
	public static void main(String[] args){
		// 1. Empty or null array;
		// 2. {1}
		// 3. Very large string;
		// 4. Contains too many (large) number or negative numbers which may exceed the limit of Integer
		// 5. Not only one max: {1, -1, 1, -1, 1, -1}
		
		int[] input = {1, -1, 1, -1, 1, -1};
		MaxSubArray test = new MaxSubArray();
		System.out.print(test.maxSubArray(input));
	}
}
