import java.util.HashSet;

// Jan 16, 2015

/**Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class LinkedListCycle {

	// Time Complexity: O(N)
	// Space Complexity: O(1)
	
	public boolean hasCycle(ListNode head) {
		if(head == null || head.next == null) return false;
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast == slow){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// 1. null or empty LinkedList
		// 2. LinkedList with 1 element and self loop
		// 3. {1,2} and no loop
		// 4. {1, 2, 3} and 3 linked to 1
		// 5. {1, 2, 3, 4} and 4 linked to 2

		// if 2(or more) cycles, will this code always work? --> Not possible to have more than one cycle
		
		LinkedListCycle s = new LinkedListCycle();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n1;
		n4.next = n2;
		System.out.println(s.hasCycle(n1));
	}

}

class ListNode{
	int val;
	ListNode next;
	ListNode (int x){
		val = x;
		next = null;
	}
}
