// Jan 20, 2015
// Reviewed: Feb 3, 2015

/**
 * You are climbing a stair case. It takes n steps to reach to 
 * the top. Each time you can either climb 1 or 2 steps. In how 
 * many distinct ways can you climb to the top?
 */

public class ClimbingStairs {
    public int climbStairs(int n) {
    	
    	// Time Complexity: O(N)????: Every time is visited
    	// Space Complexity: O(1)???
    	
        if(n <= 0) return 0; // --> Why f(0) = 1???
        if(n == 1) return 1;
        if(n == 2) return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }
    
    public int climbStairs2(int n) {
    	
    	// Time Complexity: O(N)
    	// Space Complexity: O(N)
    	
        int[] steps = new int[n + 1];
        if(n <= 0) return 0;
        if(n == 1 || n == 2){
        	return n;
        }
        
        if(n >= 3){
        	steps[0] = 0;
        	steps[1] = 1;
        	steps[2] = 2;

        	for(int i=3;i<n+1;i++){
        		steps[i] = steps[i-1] + steps[i-2];
        	}
        }
        
        return steps[n];
    }
    
    public static void main(String[] args){
    	
    	// 1. n = 0
    	// 2. n = -1;
    	// 3. very large n;
    	
    	ClimbingStairs test = new ClimbingStairs();
    	System.out.println(test.climbStairs(-1));
    	System.out.println(test.climbStairs2(25));

    }
}
