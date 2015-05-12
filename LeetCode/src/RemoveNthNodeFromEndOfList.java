// May 12, 2015

public class RemoveNthNodeFromEndOfList {
	
	// Time Complexity: O(N)
	// Space Complexity: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        for(int i=0;i<n;i++) {
            fast = fast.next;
        }
        
        if(fast == null) return head.next;
        
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }
    
    public static void main(String[] args) {
    	int length = 10;
    	ListNode[] nodes = new ListNode[length];
    	for(int i=0;i<length;i++) {
    		nodes[i] = new ListNode(i);
    	}
    	for(int i=0;i<length-1;i++) {
    		nodes[i].next = nodes[i+1];
    	}
    	ListNode node = nodes[0];
    	ListNode node2 = nodes[0];
    	RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
    	while(node != null) {
    		System.out.print(node.val + "->");
    		node = node.next;
    	}
    	test.removeNthFromEnd(nodes[0], 4);
    	System.out.println();
    	while(node2 != null) {
    		System.out.print(node2.val + "->");
    		node2 = node2.next;
    	}
    }
}
