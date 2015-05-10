
// May 9, 2015
// Page 75

public class BuildLinkedList {
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
	
	
}
