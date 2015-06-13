import java.util.HashSet;
import java.util.Set;

// Jun 12, 2015

/**
 * Given an array of integers and an integer k, find out whether
 * there there are two distinct indices i and j in the array such
 * that nums[i] = nums[j] and the difference between i and j is 
 * at most k.
 */

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(nums == null || nums.length <=1) return false;
    	if(nums.length == 2) {
    	    if(nums[0] == nums[1]) return true;
    	    else return false;
    	}
    	
        for(int i=0; i<nums.length-k; i++) {
        	for(int j=i+1; j<=i+k; j++) {
        		if(nums[i] == nums[j]) return true;
        	}
        }
        return false;
    }
    
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
    	// Cannot understand this solution.
    	if(nums == null || nums.length <=1) return false;
    	Set<Integer> set = new HashSet<Integer> ();
    	for(int i=0; i< nums.length; i++) {
    		if(i>k) set.remove(nums[i-k-1]);
    		if(!(set.add(nums[i]))) return true;
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	//Error: Could not find or load main class ContainsDuplicateII

    	ContainsDuplicateII test = new ContainsDuplicateII();
    	int[] nums = {1,2,3,4,5,6,5,4,3,2,1};
    	int k = 2;
 
    	System.out.println(test.containsNearbyDuplicate(nums, k));
    	System.out.println(test.containsNearbyDuplicate2(nums, k));

    }
}
