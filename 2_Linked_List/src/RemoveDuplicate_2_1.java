import java.util.HashSet;

// May 9, 2015
// Interview Question 2.1 page 77

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not 
 * allowed?
 */

public class RemoveDuplicate_2_1 {
	public void removeDuplicates(Node head) {
		if(head == null) return;
		
		HashSet<Integer> set = new HashSet<Integer>();
		Node cur = head;
		Node prev = new Node(-1);
		
		while(cur != null) {
			if(!set.contains(cur.data)) {
				set.add(cur.data);	
				prev.next = cur;
				prev = prev.next;
			}
			cur = cur.next;
		}		
			
		Node dummy = head;
		int count = 0;
		while(dummy != null) {
			System.out.println("The " + count + "th element is: " + dummy.data);;
			count ++;
			dummy = dummy.next;
		}
	}
		
	public void removeDuplicates2(Node head) {
		if(head == null) return;
		
		Node cur = head;
		while (cur != null) {
			Node runner = cur;
			while(runner.next != null) {
				if (runner.next.data == cur.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			cur = cur.next;
		}
		
		Node dummy = head;
		int count = 0;
		while(dummy != null) {
			System.out.println("The " + count + "th element is: " + dummy.data);
			count ++;
			dummy = dummy.next;
		}
	}
	
	class Node {
		Node next = null;
		int data;
		
		public Node(int d) {
			data = d;
		}
		
		void appendToTail(int d) {
			Node end = new Node(d);
			Node n = this;
			while (n.next != null) {
				n = n.next;
			}
			n.next = end;
		}
		
		Node deleteNode(Node head, int d) {
			Node n = head;
			
			while (n.next != null) {
				if (n.data == d) return head.next;
				while (n.next.data == d) {
					n.next = n.next.next;
					return head;
				}
				n = n.next;
			}
			return head;
		}
					
	}
	
	public static void main(String[] args) {
		RemoveDuplicate_2_1 test = new RemoveDuplicate_2_1();
		Node n1 = test.new Node(1);
		Node n2 = test.new Node(2);
		Node n3 = test.new Node(1);
		Node n4 = test.new Node(3);
		Node n5 = test.new Node(2);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		
		Node n = n1;
		int num = 0;
		System.out.println("Before:");
		while(n != null) {
			System.out.println("The " + num + "th element is: " + n.data);
			num ++;
			n = n.next;
		}
		
		System.out.println("After:");		
		test.removeDuplicates(n1);	
		System.out.println();
		test.removeDuplicates2(n1);	

		
	}
}
