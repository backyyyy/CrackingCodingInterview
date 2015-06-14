// Jun 13, 2015

/**
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * 
 * Suppose a sorted array is rotated at some pivot unknown to you 
 * beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * The array may contain duplicates.
 */

public class FindMinInRotatedSortedArrayII {
	public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
        if(nums.length == 1) return nums[0];
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++) {
        	min = Math.min(nums[i], min);
        }
        return min;
    }
	
	public int findMin2(int[] nums) {
        if(nums == null || nums.length == 0) return Integer.MIN_VALUE;
    	if(nums.length == 1) return nums[0];
    	if(nums.length == 2) return Math.min(nums[0], nums[1]);
        
        int l = 0;
        int r = nums.length-1;
        while(l < r) {
            if(nums[l] < nums[r]) {
                return nums[l];
            }
            int m = l + (r-l)/2;
            if(nums[l] > nums[m]) {
                r = m;
            } else if(nums[l] < nums[m]) {
                l = m+1;
            } else { 
                if(nums[l] == nums[r]) {
                    l++;
                    r--;
                } else { 
                    l = m+1;
                }
            }
        }
        return nums[l];
    }
	
	public static void main(String[] args) {
		int[] l1 = {};
    	int[] l2 = {1,2};
    	int[] l3 = {2,1};
    	int[] l4 = {3,1,2};
    	int[] l5 = {2,3,4,5,0,1};
    	
    	FindMinInRotatedSortedArrayII test = new FindMinInRotatedSortedArrayII();
    	System.out.println(test.findMin2(l1));
    	System.out.println(test.findMin2(l2));
    	System.out.println(test.findMin2(l3));
    	System.out.println(test.findMin2(l4));
    	System.out.println(test.findMin2(l5));
	}

}
