import java.util.Arrays;
import java.util.HashMap;

// Jan 19, 2015

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more 
 * than ⌊ n/2 ⌋ times. You may assume that the array is non-
 * empty and the majority element always exist in the array.
 */

public class MajorityElement {

    public int majorityElement(int[] nums) {
	
    	// Time Complexity: O(N);
    	// Space Complexity: O(N);   	
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<nums.length; i++){	
			
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
			
			if(map.get(nums[i]) > nums.length/2) return nums[i];
	    }
		return -1;
	}
    
    public int majorityElement2(int[] nums) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums) {
            if(map.containsKey(i)) map.put(i,map.get(i)+1);
            else map.put(i,1);
            
            if(map.get(i) > nums.length/2) return i;
        }
        return -1;  	    	
    }
    
    public int majorityElement3(int[] nums) {
    	
    	// Time Complexity: O(NLogN)
    	// Space Complexity: O(1)
    	if(nums.length == 1) return nums[0];
    	Arrays.sort(nums);
    	return nums[nums.length/2];
    }
    
    public static void main(String[] args){
    	
    	// 1. null or empty input;
    	// 2. {3,3,3,4,4,4,4}
    	// 3. {4,4,4,4,3,3,3}
    	// 4. {4,4,4,4,3,3,3,3}
    	// 5. {3,3,4}
    	// 6. {3,4,4}
    	// 7. {1}
    	
    	int[] input = {3,4,4};
    	MajorityElement test = new MajorityElement();
    	
    	System.out.println(test.majorityElement(input));
    	System.out.println(test.majorityElement2(input));
    	System.out.println(test.majorityElement3(input));

    }
}
