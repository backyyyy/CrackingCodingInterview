// Jan 27, 2015;
// Reviewed: Feb 3, 2015

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 */

// ?????????????????????????????????????????????????????????????
// Method 2 & 3 are found from the Internet and are accepted by OJ, but I found
// they are wrong...
// If draw diagram, the max area should be 18 instead of 20.

public class ContainerWithMostWater {
	public int maxArea(int[] height) {

		// Time Complexity: O(N2)
		// Space Complexity: O(N)

		int[] max = new int[height.length + 1];
		int maxArea = 0;

		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				if (height[j] > height[i]) {
					max[i] = height[i] * (j - i);
					break;
				}
				max[i] = height[height.length - 1] * (height.length - 1 - i);
			}
			maxArea = Math.max(maxArea, max[i]);
			// System.out.print("max[" + i + "]=" + max[i] + "; ");
			// System.out.println("maxArea(" + i + ")=" + maxArea);
		}
		return maxArea;
	}

	public int maxArea2(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(
					(Math.min(height[left], height[right]) * (right - left)),
					maxArea);
			// System.out.println("left=" + left + "; right=" + right +
			// "; maxArea= " + maxArea);
			if (height[left] < height[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}

	public int maxArea3(int[] height) {
		int i, j, lh, rh, area, tmp, len = height.length;

		lh = height[0];
		rh = height[len - 1];
		area = 0;
		i = 0;
		j = len - 1;

		while (i < j) {
			tmp = Math.min(lh, rh) * (j - i);

			if (tmp > area) {
				area = tmp;
			}

			if (lh < rh) {
				while (i < j && height[i] <= lh) {
					i++;
				}
				if (i < j) {
					lh = height[i];
				}
			} else {
				while (i < j && height[j] <= rh) {
					j--;
				}
				if (i < j) {
					rh = height[j];
				}
			}
		}

		return area;
	}

	public static void main(String[] args) {
		int[] height = { 2, 4, 5, 7, 1, 0, 6 };
		ContainerWithMostWater test = new ContainerWithMostWater();
		System.out.println(test.maxArea(height));
		System.out.println(test.maxArea2(height));
		System.out.println(test.maxArea3(height));

	}
}
