import java.util.HashMap;

// Jan 18, 2014

/**
 * Given an array of integers, every element appears three 
 * times except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory?
 */

public class SingleNumberII {
	public int singleNumber(int[] A) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(N)
		
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(A == null) {
        	System.out.println("Invalid Input");
        	return -1;
        }
        
    	for(int i = 0; i < A.length; i++){
    		if(map.containsKey(A[i])){
    			map.put(A[i],  map.get(A[i]) + 1);
    		} else{
    			map.put(A[i], 1);
    		}
    	}

        for(int key : map.keySet()){
    		if(map.get(key) != 3){
    			return key;
    		}
    	}
        return -1;
    }
	
	public int singleNumber2(int[] A) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
		int result = 0;
		for(int i = 0; i < 64; i ++){
			int count = 0;
			int temp = 1 << i;
			
			for(int j = 0; j < A.length; j ++){
				if((A[j] & temp) != 0)	count ++;
			}			
			if((count % 3) != 0)	result |= temp;
		}
		return result;
	}

	
	public static void main(String [] args){
		// 1. String with less than 3 elements;
		// 2. 3 elements;
		// 3. {-1, 1, -1, 1, -1} --> return code is the same as error code; --> How to solve this problem???????????????
		// 4. Too large string;
		// 5. null string;
		
		int [] A = {1};
		SingleNumberII test = new SingleNumberII();
		System.out.println(test.singleNumber(A));
		System.out.println(test.singleNumber2(A));

	}
}
