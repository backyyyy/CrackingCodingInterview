// Feb 8, 2015

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
		for(int i=0;i<A.length;i++) {
			if(A[i] == target) return true;
		}		
		return false;
	}
	
	public boolean search2(int[] A, int target) {
		
		return false;
	}
	
	public static void main(String[] args) {
    	int[] input = {4,5};
    	int target = 3;
    	SearchInRotatedSortedArrayII test = new SearchInRotatedSortedArrayII();
    	System.out.println(test.search(input, target));
	}
}
