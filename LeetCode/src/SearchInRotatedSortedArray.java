// Feb 8, 2015

/**
 * Suppose a sorted array is rotated at some pivot unknown to
 * you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the 
 * array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 */

public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
    	
    	// Time Complexity: O(logN)
    	// Space Complexity: O(1)
    	
        if(A == null || A.length == 0) return -1;
        if(A.length == 1) return A[0] == target ? 0:-1;
    	
        int l = 0;
        int r = A.length - 1;
        
        while(l <= r) {
        	int mid = l + (r-l)/2;
        	if(A[mid] == target) return mid;
        	
        	if(A[l] <= A[mid]){
        		if(A[l] <= target && target < A[mid]) {
        			r = mid - 1;
        		} else {
        			l = mid + 1;
        		}
        	} else {
        		if(A[mid] < target && target <= A[r]) {
        			l = mid + 1;
        		} else {
        			r = mid - 1;
        		}
        	}
        }
    	return -1;
    }
    
    public static void main(String[] args) {
    	
    	// 1. null or empty array
    	// 2. very long array
    	// 3. {1} target = 2;
    	// 4. {1,2} target = 1;
    	
    	int[] input = {4,5};
    	int target = 4;
    	SearchInRotatedSortedArray test = new SearchInRotatedSortedArray();
    	System.out.println(test.search(input, target));
    }
}
