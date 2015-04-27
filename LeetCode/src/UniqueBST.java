// Jan 15, 2015

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 *  1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
*/

public class UniqueBST {

	// root		1		2		3		4		5		...	n-2		n-1		n
	// left		f(0)	f(1)	f(2)	f(3)	f(4)	...	f(n-3)	f(n-2)	f(n-1)
	// right	f(n-1)	f(n-2)	f(n-3)	f(n-4)	f(n-5)	...	f(2)	f(1)	f(0)
	// The total possibilities is: SUM(f(i) * f(n-i-1))
	
	public int numTrees(int n){
		
		// Time Complexity: O(N^2)
		// Space Complexity: O(N)
		
		if(n < 0) return 0;
		int[] numBST = new int[n+1];
		numBST[0] = 1;
		numBST[1] = 1;
		
		for(int i=2; i<n+1; i++){
			for(int j=0; j<i; j++){
				numBST[i] += numBST[j] * numBST[i-j-1];
			}
			System.out.println("numBST[" +i + "] = " + numBST[i]);
		}
		
		return numBST[n];
	}
	
	public static void main(String[] args) {
		// 1. 0
		// 2. minus numbers
		// 3. very large number so out of integer bounds --> negative number --> use "long?"
		// * java docs said can use Integer to represent unsigned int after SE8, how?
		UniqueBST test = new UniqueBST();
		test.numTrees(7);
	}

}
