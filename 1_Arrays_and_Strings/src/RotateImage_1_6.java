import java.util.Arrays;

// May 7, 2015
// Interview Question 1.6 page 73

/**
 * Given an image represented by an NxN matrix, where each pixel in the 
 * image is 4 bytes, write a method to rotate the image by 90 degrees. 
 * Can you do this in place?
 */

public class RotateImage_1_6 {
	public void rotateImage (int[][] image, int n) {
		
		// Time Complexity: O(N^2)
		// Space Complexity: O(N^2)
		int[][] newImage = new int[n][n];
		for(int i = 0; i <n; i ++) {
			for (int j = 0; j <n; j ++) {
//				newImage[i][j] = image[j][n-1-i]; // clockwise					
				newImage[i][j] = image[n-1-j][i]; // counterclock
			}
		}
		
		for(int i = 0; i < n; i ++) {
			for (int j = 0; j < n; j ++) {
				image[i][j] = newImage[i][j];
			}
		}
		System.out.println("1: " + Arrays.deepToString(newImage));
	}
	
	public void rotateImage2 (int[][] image, int n) {
		
		// Time Complexity: O(N^2)
		// Space Complexity: O(N)
		for (int layer = 0; layer < n/2; layer ++) {
			int first = layer;
			int last = n-1-layer;
			for (int i = first; i < last; i ++) {
				int offset = i - first;
				int top = image[first][i];
				image[first][i] = image[last-offset][first];
				image[last-offset][first] = image[last][last - offset];
				image[last][last - offset] = image[i][last];
				image[i][last] = top;
			}
		}
		System.out.println("2: " + Arrays.deepToString(image));
	}


	public static void main(String[] args) {
		int[][] image = {{1,2,3},{4,5,6},{7,8,9}};
		RotateImage_1_6 test = new RotateImage_1_6();
		test.rotateImage(image, image.length);
//		test.rotateImage2(image, image.length);
	}
}
