import java.util.Stack;

// Jan 23, 2015

/**
 * Given an array with n objects colored red, white or blue, sort 
 * them so that objects of the same color are adjacent, with the 
 * colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the 
 * color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm 
 * using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's,
 * then overwrite array with total number of 0's, then 1's and 
 * followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only 
 * constant space?
 */

public class SortColors {
    public void sortColors(int[] A) {
    	
    	// Time Complexity: O(N);
    	// Space Complexity: O(1);
    	if(A==null || A.length==0) return;
    	
    	int[] count = new int[3];
//    	int[] temp = new int[A.length];
    	
    	for(int i=0;i<A.length;i++){
    		if(A[i] == 0) count[0]++;
    		else if(A[i] == 1) count[1]++;
    		else count[2]++;
    	}
    	System.out.println("count[0] = " + count[0]);
    	System.out.println("count[1] = " + count[1]);
    	System.out.println("count[2] = " + count[2]);
    	
    	for(int i=0;i<count[0];i++){
//    		temp[i] = 0;
    		A[i] = 0;
    	}
    	for(int i=count[0];i<count[0]+count[1];i++){
//    		temp[i] = 1;
    		A[i] = 1;
    	}
    	for(int i=count[0]+count[1];i<A.length;i++){
//    		temp[i] = 2;
    		A[i] = 2;
    	}
    	
//    	for(int i=0;i<A.length;i++){
//    		A[i] = temp[i];
//    		System.out.println(A[i]);
//    	}
    }
    
    public static void main(String[] args){
    	
    	// 1. Null or empty string;
    	// 2. {1,1,1,1,1,1,1,};
    	// 3. Very long string;
    	// 4. The string contains words other than "0,1,2"
    	
    	int[] input = null;
    	SortColors test = new SortColors();
    	test.sortColors(input);
    }
}
