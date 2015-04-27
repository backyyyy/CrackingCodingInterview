import java.util.Arrays;

// Jan 27,2015

/**
 * Given a m x n grid filled with non-negative numbers, find 
 * a path from top left to bottom right which minimizes the 
 * sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point
 * in time.
 */

public class MinPathSum {
	public int minPathSum(int[][] grid) {
		
		// Time Complexity: O(N^2)
		// Space Complexity: O(N^2)
		
		int rows = grid.length;
		int cols = grid[0].length;
		
		if(grid==null || rows==0 || cols==0) return 0;

		int[][] minPath = new int[rows][cols];
		minPath[0][0] = grid[0][0];
		System.out.println("minPath[0][0]=" + minPath[0][0]);
		for(int i=1;i<cols;i++)	{
			minPath[0][i] = minPath[0][i-1] + grid[0][i];
			System.out.println("minPath[0][" + i + "]=" + minPath[0][i]);
		}
		for(int i=1;i<rows;i++)	{
			minPath[i][0] = minPath[i-1][0] + grid[i][0];
			System.out.println("minPath[" + i + "][0]=" + minPath[i][0]);
		}

		for(int i=1;i<rows;i++){
			for(int j=1;j<cols;j++){
				minPath[i][j] = Math.min(minPath[i-1][j], minPath[i][j-1]) + grid[i][j];
				System.out.println("minPath[" + i + "][" + j + "]=" + minPath[i][j]);
			}
		}
		return minPath[rows-1][cols-1];
    }
	
	public int minPathSum2(int[][] grid) {
		
		// Time Complexity: O(N^2)
		// Space Complexity: O(N)
		
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[] minPath = new int[cols];
        Arrays.fill(minPath, Integer.MAX_VALUE); // Should be integer.max because we need to choose the smaller
        minPath[0] = 0;

        for(int i = 0; i < rows; i++) {
        	minPath[0] = minPath[0] + grid[i][0];
            for(int j = 1; j < cols; j++) {
           	minPath[j] = grid[i][j] + Math.min(minPath[j], minPath[j - 1]);
            }
        }        
        return minPath[cols - 1];
    }
	
	
	public static void main(String[] args){
		
		// 1. Null or empty array
		// 2. 1*N or N*1 array
		// 3. very large array
		// 4. array with very large amount
		
		int[][] grid = {{1,2,3},{1,2,3},{1,2,3}};
		
		MinPathSum test = new MinPathSum();
		
//		System.out.println(test.minPathSum(grid));
		System.out.println(test.minPathSum2(grid));

	}
	
	
}
