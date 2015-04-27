import java.util.ArrayList;
import java.util.Arrays;

// Feb 03, 2015

/**
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place?
 */

public class RotateImage {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int[][] result = new int[n][n];
		System.out.println("row = " + n + "; col = " + n);
		
		// matrix[x][i] -> matrix'[i][n-x+1]
       for(int i=0;i<n;i++){
    	   for(int j=0;j<n;j++){
    		   result[i][j] = matrix[n-j-1][i];
    	   }
       }
       
       System.out.println(Arrays.deepToString(result));
       
       for(int i=0;i<n;i++){
    	   for(int j=0;j<n;j++){
    		   matrix[i][j] = result[i][j];
    	   }
       }
    }
	
	public void rotate2(int[][] matrix){
		int n = matrix.length;
		int[][] temp = new int[n][n];
		
	}
	
	public static void main(String[] args){
//		int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] input = {{1,2},{4,5}};
		RotateImage test = new RotateImage();
		test.rotate(input);
	}

}
