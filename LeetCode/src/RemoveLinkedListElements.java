// May 10, 2015

/**
 * Remove all elements from a linked list of integers that have value
 * val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class RemoveLinkedListElements {

	public ListNode removeElements(ListNode head, int val) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		if(head == null) return null;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode cur = head;
		ListNode prev = dummy;
		
		while(cur != null) {
			if(cur.val == val) {
				prev.next = cur.next;
			} else {
				prev = prev.next;
			}
			cur = cur.next;
		}
		return dummy.next;
    }
	
	public ListNode removeElements2(ListNode head, int val) {
		if(head == null) return null;
		if(head.val == val) return removeElements2(head.next, val);
		head.next = removeElements2(head.next,val);
		
		return head;
	}

	
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
