// Feb 8, 2015, Jun 20, 2015

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */

public class SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;

		for(int i=0;i<nums.length;i++) {		
			System.out.println(i + ": ");
			if(nums[i] == target) return true;
		}		
		return false;
	}
	
	public boolean search2(int[] nums, int target) {
		
		// This solution is copied from LeetCode, but not accepted
		if(nums == null || nums.length == 0) return false;
		int left = 0, right = nums.length-1;
		
		while(left <= right) {
			int mid = left + (right-left)/2;
			if(nums[mid] == target) return true;
			
			if(nums[left] < nums[mid]) {
				if(nums[mid] < target && target <= nums[right]) 
					right = mid - 1;
				else 
					left = mid + 1;
			} else if(nums[left] > nums[mid]) {
				if(nums[mid] < target && target <= nums[right]) 
					left = mid + 1;
				else 
					right = mid - 1;
			} else 
				left ++;			
		}
		return false;
	}
	
	public static void main(String[] args) {
    	int[] input = {3,3,4,5};
    	int target = 4;
    	SearchInRotatedSortedArrayII test = new SearchInRotatedSortedArrayII();
    	System.out.println(test.search(input, target));
	}
}
