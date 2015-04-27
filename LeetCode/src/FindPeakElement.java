// Jan 25, 2015
// Reviewed: Feb 3, 2015 --> Not familiar.

/**
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ¡Ù num[i+1], find a peak 
 * element and return its index.
 * 
 * The array may contain multiple peaks, in that case return the
 * index to any one of the peaks is fine.
 * 
 * You may imagine that num[-1] = num[n] = -¡Þ.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and 
 * your function should return the index number 2.
 * 
 * Note:
 * Your solution should be in logarithmic complexity.
 */

public class FindPeakElement {
	public int findPeakElement(int[] num) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
		if(num == null || num.length == 0) return -1;
		if(num.length == 1) return 0;
		
        for(int i=1;i<num.length;i++){
        	if(num[i]<num[i-1]) {
        		return i-1;
        	}        	
        }
        return num.length-1;   
    }
	
	public int findPeakElement2(int[] num){
		
		// Time Complexity: O(logN)
		// Space Complexity: O(1)
		
		int l = 0;
		int r = num.length -1;
		
		while(l <= r){
			if(l==r) return l;
			
			int mid = (l+r)/2;
			if(num[mid] < num[mid+1]){
				l = mid + 1;
			} else {
				r = mid;
			}
//			if(l==r) return l;
		}
		return -1;
	}
	
	public int findPeakEmelent3(int[] num){
		int l = 0;
		int r = num.length - 1;
		
		while(l<r-1){
			if(l == r) return l;
			
			int mid = l + (r-l)/2;
			if(num[mid] > num[mid-1] && num[mid] > num[mid+1]) return mid;
			else if(num[mid] > num[mid-1] && num[mid] < num[mid+1]) l = mid;
			else if(num[mid] < num[mid-1] && num[mid] > num[mid+1]) r = mid;
			else l = mid;
		}
		return num[l] > num[r] ? l : r;
	}
	
	public static void main(String[] args){
		
		// 1. null or empty string;
		// 2. Only 1 element
		// 3. {1,2,3,2,1}
		// 4. {1,2,3,3,2,1}
		// 5. {1,1,1,1,1}
		// 6. Very long string
		
		int[] input = {1,2,3,3,2,1};
		FindPeakElement test = new FindPeakElement();
		System.out.println(test.findPeakElement(input));
		System.out.println(test.findPeakElement2(input));
		System.out.println(test.findPeakEmelent3(input));

	}
}
