// Jun 21, 2015

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * (A,B) and (C,D) VS (E,F) and (G, H)
 * 
 * Each rectangle is defined by its bottom left corner and top right 
 * corner as shown in the figure.
 * 
 * Assume that the total area is never beyond the maximum possible value 
 * of int.
 */

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int s1 = (C-A) * (D-B);
        int s2 = (G-E) * (H-F);
        int s0 = 0;
        
        int minRight = Math.min(C, G);      
        int maxLeft = Math.max(A, E);    
        int minUpper = Math.min(D, H);
        int maxLower = Math.max(B, F);
        
        if(maxLeft < minRight && maxLower < minUpper) 
        	s0 = (minRight - maxLeft) * (minUpper - maxLower);

        return s1 + s2 - s0;
    }
}
