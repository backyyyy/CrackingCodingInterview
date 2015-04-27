// Jan 13, 2015

import java.util.HashMap;

/**
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) 
 * are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 
 */

public class TwoSum {

	// Time Complexity: O(N)
	// Space Complexity: O(N)
	
    public int[] twoSum(int[] numbers, int target) {  	
    	int num1, num2;
    	int[] answer = new int[2];
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        
        for(int i=0;i<numbers.length;i++){
        	if(m.containsKey(numbers[i])){
        		num1 = i+1;
        		num2 = (int) m.get(numbers[i]);
                answer[0] = Math.min(num1, num2);
                answer[1] = Math.max(num1, num2);
        		break;
        	} else{
        		m.put(target-numbers[i], i+1);
        	}
        }
        return answer;
    }
    
    public static void main(String[] args){
    	//Test cases:
    	// 1. null array;
    	// 2. {a, b, c, d, e};
    	// 3. {1, -2, 3, -4, 5} target = -1;
    	// 4. super large numbers;
    	// 5. no such combination in numbers;
    	// 6. numbers.length <2;
    	
    	int[] input = {2,7,11,15};
    	TwoSum test = new TwoSum();
    	int[] output = test.twoSum(input, 9);
    	for(int i=0;i<output.length;i++){
    		System.out.println(output[i]);
    	}
    }
}

