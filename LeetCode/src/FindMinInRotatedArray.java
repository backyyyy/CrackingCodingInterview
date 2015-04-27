// Jan 21, 2015
// Reviewed: Feb 3, 2015 --> Not familiar.

/**
 * Suppose a sorted array is rotated at some pivot unknown to 
 * you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 */

public class FindMinInRotatedArray {
    public int findMin(int[] num) {
    	
    	// Time Complexity: O(N)
    	// Space Complexity: O(1)
    	
    	if(num == null || num.length == 0) return Integer.MIN_VALUE;
    	if(num.length ==1) return num[0];
    	
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<num.length;i++){
        	min = Math.min(min, num[i]);
        }
        
        return min;
    }
    
    public int findMin2(int[] num){
    	
    	// Time Complexity: O(logN)
    	// Space Complexity: O(1)
    	
    	if(num == null || num.length == 0) return Integer.MIN_VALUE;
    	if(num.length == 1) return num[0];
    	if(num.length == 2) return Math.min(num[0], num[1]);
    	
    	int l = 0;
    	int r = num.length-1;
    	int min = num[0];
    	
    	while(l < r-1){
    		int m = l + (r-l)/2;
    		if(num[l] < num[m]){
    			min = Math.min(num[l], min);
    			l = m+1;
    		} else if(num[l] > num[m]){
    			min = Math.min(num[m], min);
    			r = m-1;
    		} else{
    			l++;
    		}
    	}
    	
    	min = Math.min(num[r], min);
    	min = Math.min(num[l], min);
    	return min;   	
	}
 
    public static void main(String[] args){
    	
    	int[] l1 = {};
    	int[] l2 = {1,2};
    	int[] l3 = {2,1};
    	int[] l4 = {3,1,2};
    	int[] l5 = {2,3,4,5,0,1};
    	
    	FindMinInRotatedArray test = new FindMinInRotatedArray();
    	System.out.println(test.findMin2(l1));
    	System.out.println(test.findMin2(l2));
    	System.out.println(test.findMin2(l3));
    	System.out.println(test.findMin2(l4));
    	System.out.println(test.findMin2(l5));
    }
}
