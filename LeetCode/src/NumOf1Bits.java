// May 3, 2015

/**
 * Write a function that takes an unsigned integer and returns the 
 * number of ¡¯1' bits it has (also known as the Hamming weight).
 * 
 * For example, the 32-bit integer ¡¯11' has binary representation 
 * 00000000000000000000000000001011, so the function should return 
 * 3.
 * 
 * Credits:
 * Special thanks to @ts for adding this problem and creating all 
 * test cases.
 */

public class NumOf1Bits {
	public int hammingWeight(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
		int count = 0;
		while(n != 0) {
			n = n & (n-1);
			count ++;
		}
        return count;
    }
	
	public int hammingWeight2(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        
        int count = 0;        
        while (n != 0) {
        	if((n & 1) == 1) count ++;
        	n = n >> 1;
        }
        
        return count;
	}
	
	public static void main(String[] args) {
		int n = 5;
		NumOf1Bits test = new NumOf1Bits();
		System.out.println(test.hammingWeight(n));
		System.out.println(test.hammingWeight2(n));
	}
}
