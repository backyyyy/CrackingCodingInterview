import java.util.HashMap;

// Jan 19, 2015

/**
 * Given an array of size n, find the majority element. 
 * The majority element is the element that appears more 
 * than ⌊ n/2 ⌋ times. You may assume that the array is non-
 * empty and the majority element always exist in the array.
 */

public class MajorityElement {

    public int majorityElement(int[] num) {
	
    	// Time Complexity: O(N);
    	// Space Complexity: O(N);
    	
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for(int i=0; i<num.length; i++){	
			
			if(map.containsKey(num[i])){
				map.put(num[i], map.get(num[i]) + 1);
			} else {
				map.put(num[i], 1);
				System.out.println("2. map.get(" + num[i] + ")= " + map.get(num[i]));
			}
			
			if(map.get(num[i]) > num.length/2) return num[i];
	    }
		return -1;
	}
    
//    public int majorityElement(int[] num) {
//    	
//    }
//    
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
    }
}
