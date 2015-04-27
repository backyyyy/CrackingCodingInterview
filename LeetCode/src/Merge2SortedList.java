import java.util.LinkedList;

// Jan 20, 2015

/**
 *Merge two sorted linked lists and return it as a new list. 
 *The new list should be made by splicing together the nodes of 
 *the first two lists.
 */
public class Merge2SortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	// Time Complexity: O(N)
    	// Space Conplexity: O(1)
    	
        ListNode dummy = new ListNode(-1);
        ListNode runner = dummy;  
        
        if(l1==null && l2==null) return null;
               
        while(l1!=null && l2!=null){       	
	        if(l1.val <=l2.val){
	        	runner.next = l1;
	        	l1 = l1.next;
	        } else{
	        	runner.next = l2;
	        	l2 = l2.next;
	        }
	        runner = runner.next; 
        }
        
        while(l1!=null && l2==null){
        	runner.next = l1;
        	l1 = l1.next;
        	runner = runner.next;
        }
        
        while(l2!=null && l1==null){
        	runner.next = l2;
        	l2 = l2.next;
        	runner = runner.next;
        }
        
        return dummy.next;
               
    }	
    
    public static void main(String[] args){   
    	
    	// 1. both null
    	// 2. One of the two arrays is null
    	// 3. Same array
    	
    	ListNode a1 = new ListNode(1);
    	ListNode a2 = new ListNode(3);
    	ListNode a3 = new ListNode(7);
    	ListNode a4 = new ListNode(12);
    	ListNode a5 = new ListNode(18);
    	ListNode a6 = new ListNode(21);
    	    	
    	a1.next = a2;
    	a2.next = a3;
    	a3.next = a4;
    	a4.next = a5;
    	a5.next = a6;
      	
      	ListNode b1 = new ListNode(5);
    	ListNode b2 = new ListNode(9);
    	ListNode b3 = new ListNode(10);
    	ListNode b4 = new ListNode(12);
    	ListNode b5 = new ListNode(16);
    	ListNode b6 = new ListNode(27);
      	
    	b1.next = b2;
    	b2.next = b3;
    	b3.next = b4;
    	b4.next = b5;
    	b5.next = b6;
    	
    	ListNode c1 = new ListNode(1);
    	ListNode c2 = new ListNode(3);
    	ListNode c3 = new ListNode(7);
    	ListNode c4 = new ListNode(12);
    	ListNode c5 = new ListNode(18);
    	ListNode c6 = new ListNode(21);
    	    	
    	c1.next = c2;
    	c2.next = c3;
    	c3.next = c4;
    	c4.next = c5;
    	c5.next = c6;
    	
      	Merge2SortedList test = new Merge2SortedList();
      	ListNode temp = test.mergeTwoLists(a1,c1);
      	ListNode node = temp;
      	while(node != null){
      		System.out.println(node.val);
      		node = node.next;
      	}
    	
    }
}
