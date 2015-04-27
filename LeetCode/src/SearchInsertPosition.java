// Jan 17, 2015

/**
 * Given a sorted array and a target value, return the index if the target 
 * is found. If not, return the index where it would be if it were inserted 
 * in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 */

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
		int value;
		int position = 0;
		
		while(position < A.length){
	
			value = A[position];
			if(value < target) {				
				position ++;
			}else break;
		}
		return position;
    }
	
	public int searchInsert2(int[] A, int target){
		
		// Time Complexity: O(logN)
		// Space Complexity: O(1)
		
		int low = 0;
		int high = A.length -1;

		while(low <= high){
			int mid = low + (high - low)/2;
			if(A[mid] == target){
				return mid;
			}else if(A[mid] > target){
				high = mid -1;
			}else
				low = mid + 1;
		}
		return low;	
	}
	
	public static void main(String[] args){
		int[] A = {1, 3, 5, 7, 8, 12};
		int target = 9;
		SearchInsertPosition test = new SearchInsertPosition();
		System.out.println(test.searchInsert(A, target));
		System.out.println(test.searchInsert2(A, target));

	}
}
