// Jan 18, 2015

/**
 * Given a sorted linked list, delete all duplicates 
 * such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class RemoveDupSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
		ListNode cur = head;
		
		if(cur == null || cur.next == null){
			return head;
		}
		
		while(cur != null && cur.next != null){
			if(cur.val == cur.next.val){
				cur.next = cur.next.next;
			}else{
				cur = cur.next;
			}
		}
		return head;
	}
//	
//	public class ListNode {
//		int val;
//		ListNode next;
//		ListNode(int x) {
//			val = x;
//			next = null;
//		}
//	}
	
	public static void main(String[] args){
		
		// 1. null, empty list or only 1 element
		// 2. very long list
		// 3. What else???????????????????????????????
		
		ListNode[] list = new ListNode[5];
		RemoveDupSortedList test = new RemoveDupSortedList();
		
		for(int i = 0; i < 5; i ++){
			list[i] = new ListNode(i);
		}
		
		ListNode result = test.deleteDuplicates(list[0]);
		System.out.println(result.val);

	}
}
