// May 14, 2015
/**
 * Reverse a singly linked list.
 * 
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you 
 * implement both?
 */

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode tail = reverseList(head.next);
        System.out.println("tail = " + tail);
        head.next.next = head;
        head.next = null;
        return tail;
    }
	
	/*
	One iterative idea. Use a dummy node as the 'head', insert all subsequent node into the dummy.next
	For example, the original list is 1->2->3->null
	Adding a dummy node, it will become dummy->1->2->3->null

	Insert 1 to dummy.next, and the list becomes dummy->1->2->3->null
	Insert 2 to dummy.next, and the list becomes dummy->2->1->3->null
	Insert 3 to dummy.next, and the list becomes dummy->3->2->1->null
	When the node is null, return dummy.next, which is 3
	*/
	
	public ListNode reverseList2(ListNode head) {
		ListNode newHead = null;
		while( head != null) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
	
	public ListNode reverseList3(ListNode head) {
		if(head == null) return null;
		ListNode node = head, prev = null, reversed = null;
		
		while (node != null) {
			final ListNode next = node.next;
			
			if(node.next == null) reversed = node;
			node.next = prev;
			prev = node;
			node = next;
		} 
		
		return reversed;
	}
	
	public ListNode reverseList4(ListNode head) {
	       if(head==null|| head.next==null) {
	            return head;
	        }
	        ListNode prev = null;
	        ListNode cur = head;
	        ListNode next = null;
	        
	        while(cur != null) {
	            next = cur.next;
	            cur.next = prev;
	            prev = cur;
	            cur = next;
	        }
	        head = prev;
	        
	        return head;
	    }	
    
    public static void main(String[] args) {
    	int length = 10;
    	ListNode[] nodes = new ListNode[length];
    	for(int i=0;i<length;i++) {
    		nodes[i] = new ListNode(i);
    	}
    	for(int i=0;i<length-1;i++){
    		nodes[i].next = nodes[i+1];
    	}
    	ListNode head = nodes[0];
    	while(head != null){
    		System.out.print(head.val + "->");
    		head = head.next;
    	}
    	System.out.println();
    	ReverseLinkedList test = new ReverseLinkedList();
    	ListNode newHead = test.reverseList(nodes[0]);
    	while(newHead != null){
    		System.out.print(newHead.val + "->");
    		newHead = newHead.next;
    	}
    }
}
