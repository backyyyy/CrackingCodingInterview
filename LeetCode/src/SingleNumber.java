// Jan 13, 2015

import java.util.Hashtable;
import java.util.Iterator;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */

public class SingleNumber {
	
	// Time Complexity: O(N) for both
	// Space Complexity: O(N) for singleNumber1, O(1) for singleNumber2
	
	 public int singleNumber1(int[] A) {
		 Hashtable<Integer, Integer> m = new Hashtable<Integer, Integer>();
		 for(int i=0;i<A.length;i++){
			 if(m.containsKey(A[i])){
				 m.put(A[i],m.get(A[i])+1);
			 }else{
				 m.put(A[i],1);
			 }
		 }
		 
		 for(Integer key:m.keySet()){
			 if(m.get(key) == 1) return key;
		 }
		 return -1;
	 }
	 
	 public int singleNumber(int[] A){
		 int result = 0;
		 for(int i=0; i<A.length; i++){
			 result ^= A[i];
		 }
		 return result;
	 }
	 
	 public static void main(String[] args){
		 // 1. null or empty array;
		 // 2. more than one single;
		 // 3. array length = 1;
		 // 4. A is very large, so i cannot reach A.length;
		 // 5. {2,2,2,2,2} or {2,3,2,3,2}
		 int[] input = {1, 2, 3, 2, 1};
		 SingleNumber test = new SingleNumber();
		 System.out.println(test.singleNumber(input));
	 }
}
