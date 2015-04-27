import java.util.HashMap;

// Jan 21, 2015

/**
 * Given an array and a value, remove all instances of that value 
 * in place and return the new length.
 * The order of elements can be changed. It doesn't matter what 
 * you leave beyond the new length.
 */

public class RemoveElement {
    public int removeElement(int[] A, int elem) {
    	
    	// Why this solution cannot pass!!!!
    	
    	if(A == null || A.length == 0) return 0;
    	
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<A.length;i++){
        	if(map.containsKey(A[i])) map.put(A[i], map.get(A[i])+1);
        	else map.put(A[i], 1);
        }
        if(map.containsKey(elem)){
        	int len = map.get(elem);
        	return A.length-len;
        }
        else return A.length;
    }
    
    public int removeElement2(int[] A, int elem){
    	
    	// Time Complexity: O(N^2)
    	// Space Complexity: O(1)
    	
        int i=0, j=0;
        while(j<A.length){
            if(A[j]!=elem){
                A[i]=A[j];
                i++; 
            }
            j++;
        }
        return i;
    }
    
    public static void main(String[] args){
    	
    	// 1. Null or empty array
    	// 2. {1,1,1,1} remove 1
    	// 2. {1,1,1,1} remove 0
    	// 3. very long array: will the program take too long time to process?
    	// 4. What else?
    	
    	int[] input = {1,1,1,1};
    	System.out.println("Original length: " + input.length);
    	RemoveElement test = new RemoveElement();
    	System.out.println("Final length 1 = " + test.removeElement(input, 1));
    	System.out.println("Final length 2 = " + test.removeElement(input, 1));

    }
}
