import java.util.HashSet;

// May 10, 2015

/**
 * Write a program to find the node at which the intersection of two 
 * singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * A:          a1 ¡ú a2
 *                    ¨K
 * 					  c1 ¡ú c2 ¡ú c3
 *                    ¨J      
 * B:     b1 ¡ú b2 ¡ú b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * - If the two linked lists have no intersection at all, return null.
 * - The linked lists must retain their original structure after the 
 * function returns.
 * - You may assume there are no cycles anywhere in the entire linked 
 * structure. 
 * - Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class InsertionOfTwoLInkedLists {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
		// Time Complexity: O(N)
		// Space Complexity: O(1) 
		if(headA == null || headB == null) return null;
        
        ListNode curA = headA;
        ListNode curB = headB;
        
        while(curA != curB) {
        	curA = curA == null ? headB : curA.next;
        	curB = curB == null ? headA : curB.next;
        }
        return curA;
    }
	
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
		
		// Time Complexity: 
		if(headA == null || headB == null) return null;
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(headA != null || headB != null) {
            if(headA != null) {
                if(set.contains(headA)) return headA;
                else set.add(headA);
                headA = headA.next;
            }
            if(headB != null) {
                if(set.contains(headB)) return headB;
                else set.add(headB);
                headB = headB.next;
            }
        }
        return null;
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
			next = null;
		}
	}

}
