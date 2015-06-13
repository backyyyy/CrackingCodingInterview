import java.util.Arrays;
import java.util.HashSet;

// Jun 12, 2015

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice 
 * in the array, and it should return false if every element is distinct.
 */

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
    	if(nums == null || nums.length <= 1) return false;
        HashSet<Integer> set = new HashSet<Integer> ();
        for(int n : nums) {
        	if(set.contains(n)) return true;
        	else set.add(n);
        }
        return false;
    }
    
    public boolean containsDuplicate2(int[] nums) {
    	if(nums == null || nums.length <= 1) return false;
    	Arrays.sort(nums);
    	for(int i=1; i<nums.length; i++) {
    		if(nums[i] == nums[i-1]) return true;
    	}
    	return false;
    }
}
