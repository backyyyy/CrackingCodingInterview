// Jan 26, 2015

/**
 *Given a sorted array, remove the duplicates in 
 *place such that each element appear only once and
 *return the new length.
 *
 *Do not allocate extra space for another array, 
 *you must do this in place with constant memory.
 *
 *For example,
 *Given input array A = [1,1,2], your function 
 *should return length = 2, and A is now [1,2].
 */

public class RemoveDupFromSortedArray {
	public int removeDuplicates(int[] A) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
        if(A == null || A.length==0) return 0;
		if(A.length == 1) return 1;
		
		int count = 1;
        for(int i=0;i<A.length-1;i++){
        	if(A[i] != A[i+1]) count ++;
        }
        
        return count; 
    }
	
	public int removeDuplicates2(int[] A){
		
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
        if(A == null || A.length==0) return 0;
		if(A.length == 1) return 1;
		
		int count = 1;
		
		for(int i=0;i<A.length -1; i++){
			if(A[i] != A[i+1]) {
				count ++;
				A[count-1] = A[i+1];
			}
		}
		
		for(int i=0;i<count;i++){
			System.out.println("A[" + i + "] = " + A[i]);
		}
		return count;
	}
	
	public static void main(String[] args){
		// 1. Null or empty space
		// 2. {1}
		// 3. {1,1};
		// 4. {1,1,1};
		// 5. {1,2,3,4,5};
		// 6. {1,1,2,3,3,3,3,3,4};
		// 7. Too long array
		
		int[] A = {1,2,3,4,5};
		RemoveDupFromSortedArray test = new RemoveDupFromSortedArray();
		System.out.println(test.removeDuplicates(A)); 
		System.out.println(test.removeDuplicates2(A)); 

	}
}
