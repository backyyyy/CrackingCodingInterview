// Jan 21, 2015

/**
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below). The robot can only 
 * move either down or right at any point in time. The robot 
 * is trying to reach the bottom-right corner of the grid 
 * (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 */
public class UniquePath {
	
	public int uniquePaths(int m, int n){
		
		// Time Complexity: O(N) ??? or O(N2)???
		// Space Complexity: O(N)
		
		if(m==0 || n==0) return 0;
		if(n==1 || n==1) return 1;
		 
		return(uniquePaths(m-1,n) + uniquePaths(m,n-1));
	}
	
	 public int uniquePaths2(int m, int n) {
		 
		 // Time Complexity: O(N)
		 // Space Complexity: O(N)
		 
		 if(m==0 || n==0) return 0;
		 if(n==1 || n==1) return 1;
		 
		 // Total steps for M*N: C(M-1,N-1)=C(M-1,N-1-1)+C(M-1-1,N-1);
		 //					f(m,n) = f(m,n-1) + f(m-1,n) 
		 
		 int[][] answer = new int[m][n];
		 
		 for(int i=0;i<m;i++){
			 answer[i][0] = 1;
		 }
		 
		 for(int j=0;j<n;j++){
			 answer[0][j] = 1;
		 }
		 
		 for(int i=1;i<m;i++){
			for(int j=1;j<n;j++){
				answer[i][j] = answer[i-1][j] + answer[i][j-1];
			}
		 }
		 		 
		 return(answer[m-1][n-1]);
	 }
	 
	 public static void main(String[] args){
		 
		 // 1. (0,0)
		 // 2. (0,1) or (1,0)
		 // 3. (2000, 1000)
		 // 4. (1, 100000) or (100000, 1)
		 // 5. What else?
		 
		 UniquePath test = new UniquePath();
		 System.out.println(test.uniquePaths(4, 11));
	 }

}
