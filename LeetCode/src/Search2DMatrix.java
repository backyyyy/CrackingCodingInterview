// Feb 07, 2015

/**
 * Write an efficient algorithm that searches for a value in an 
 * m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer 
 * of the previous row.
 * 
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * 
 * Given target = 3, return true.
 */

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		
		// This method cannot get right answer if target is in 1st column
        if(matrix == null) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i=row-1;i>-1;i--){
        	if(target == matrix[i][0]) return true;
        	else if(target < matrix[i][0]){
        		break;
        	} else {       		
        		for(int j=0;j<col;j++){
        			if(target == matrix[i][j]){
        				return true;
        			} else if(target < matrix[i][j]){
        				return false;
        			}
        		}
        	}
        }
		return false;
    }
	
	public boolean searchMatrix2(int[][] matrix, int target){
		
		// Time Complexity: O(log(m*n))
		// Space Complexity: O(1)
		if(matrix == null) return false;
		int row = matrix.length;
		int col = matrix[0].length;
		
		int start = 0;
		int end = row * col -1;
		
		while(start <= end){
			int mid = (start + end) / 2;
			int midX = mid / col;
			int midY = mid % col;
			
			if(matrix[midX][midY] == target) return true;
			if(matrix[midX][midY] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args){
//		int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] input = {{0,1,1},{2,3,5}};
		Search2DMatrix test = new Search2DMatrix();
		System.out.println(test.searchMatrix(input, 1));
		System.out.println(test.searchMatrix2(input, 1));

	}
}
