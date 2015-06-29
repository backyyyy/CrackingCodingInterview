import java.util.LinkedList;
import java.util.List;

// Jun 28, 2015

/**
 * Given an integer array of size n, find all elements that appear more 
 * than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) 
 * space.
 * 
 * Hint:
 * How many majority elements could it possibly have?
 * Do you have a better hint? Suggest it!
 */

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> majority = new LinkedList<Integer>();
        if(nums == null) return null;
        if(nums.length == 0) return majority;
        if(nums.length == 1) {
            majority.add(nums[0]);
            return majority;
        }

        int c1 = 0,c2 = 0;
        int n1 = 0,n2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	int n3 = nums[i];
        	if(c1 > 0 && c2 > 0) {
        		if(n3 != n1 && n3 != n2) {
        			c1 --;
        			c2 --;
        		} else if(n3 == n1) {
        			c1 ++;
        		} else {
        			c2 ++;
        		}
        	} else if(c1 > 0) {
        		if(n3 == n1) {
        			c1 ++;
        		} else {
        			n2 = n3;
        			c2 ++;
        		}
        	} else if(c2 > 0) {
        		if(n3 == n2) {
        			c2 ++;
        		} else {
        			n1 = n3;
        			c1 ++;
        		}
        	} else {
        		n1 = n3;
        		c1 ++;
        	}
        }

        c1 = c2 = 0;
        for (int i = 0; i < nums.length; i++) {
        	if(nums[i] == n1) c1 ++;
        	else if(nums[i] == n2) c2 ++;
        }
        
        if(c1 > nums.length/3) {
        	majority.add(n1);
        }
        if(c2 > nums.length/3) {
        	majority.add(n2);
        }

        return majority;
    }
	
	public static void main(String[] args) {
		int[] input = {1,2,3,3,2,1};
		MajorityElementII test = new MajorityElementII();
		test.majorityElement(input);
	}
}
