// Jan 24, 2015

/**
 * Given a linked list, swap every two adjacent nodes and 
 * return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not 
 * modify the values in the list, only nodes itself can be 
 * changed.
 */

public class SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		
		// Time Complexity: O(N)
		// Space Complexity: O(1)
		
        if(head == null || head.next == null) return head;
        
		ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = head;
        
        while(second != null && second.next != null){
        	
        	first.next = second.next;
        	second.next = second.next.next;
        	first.next.next = second;
        	
        	System.out.println("first=" + first.val);
        	System.out.println("second=" + second.val);
        	
        	first = second;
        	second = first.next; 	
        }
        
        return dummy.next;
    }
	
	public static void main(String[] args){
		
		// 1. null or empty array
		// 2. {1}
		// 3. {1,2}
		// 4. {1,2,3}
		// 5. very long array
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		SwapNodesInPairs test = new SwapNodesInPairs();
		test.swapPairs(n1);
		
	}
}
