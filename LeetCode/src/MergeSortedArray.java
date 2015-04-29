import java.util.Arrays;

// Apr 28, 2015

/**
 * Given two sorted integer arrays A and B, merge B into A as one 
 * sorted array.
 * 
 * Note:
 * You may assume that A has enough space (size that is greater or 
 * equal to m + n) to hold additional elements from B. The number 
 * of elements initialized in A and B are m and n respectively.
 */

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
		int i = m-1;
        int j = n-1;
        int p = m+n-1;
        
        while(i>-1 && j>-1){
            if(A[i] > B[j]) {
                A[p] = A[i];
                i--;
                p--;
            } else {
                A[p] = B[j];
                j--;
                p--;
            }
        }
        
        while(i>-1){
            A[p] = A[i];
            i--;
            p--;
        }
        
        while(j>-1){
            A[p] = B[j];
            j--;
            p--;
        }
    }
	
	public static void main(String[] args) {
		// 1. null or empty array
		// 2. two identical arrays
		// 3. very long arrays
		
		int[] A = {1,3,5,7,8,13,0,0,0,0,0};
		int[] B = {2,4,9,10,11};
		
		MergeSortedArray test = new MergeSortedArray();
		test.merge(A, 6, B, 5);
		System.out.println(Arrays.toString(A));
		
	}
}
