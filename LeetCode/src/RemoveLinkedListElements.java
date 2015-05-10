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
		if(head == null) return null;
		ListNode prev = new ListNode(-1);
		prev.next = head;
		ListNode cur = prev;
		
		while(cur.next != null) {
			if(cur.next.val == val) {
				ListNode tmp = cur.next;
				cur.next = tmp.next;
			}
			else {
				cur = cur.next;
			}
		}
		return prev.next;
    }
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
