// Feb 05, 2015
// Reviewed: Feb 07, 2015

/**
 * Given a binary tree struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode
 * *right; TreeLinkNode *next; }
 * 
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect
 * binary tree (ie, all leaves are at the same level, and every parent has two
 * children).
 * 
 * Follow up for problem "Populating Next Right Pointers in Each Node". What if
 * the given tree could be any binary tree? Would your previous solution still
 * work?
 * 
 * Note: You may only use constant extra space.
 * 
 * For example, Given the following binary tree, 
 * 		1 
 * 	   / \ 
 * 	  2   3 
 * 	 / \   \ 
 *  4   5   7
 * 
 * After calling your function, the tree should look like: 
 * 		1 -> NULL 
 * 	   / \ 
 * 	  2 -> 3 -> NULL 
 * 	 / \    \ 
 *  4-> 5 -> 7 -> NULL
 * 
 * Definition for binary tree with next pointer. 
 * public class TreeLinkNode { 
 * 	int val; 
 * 	TreeLinkNode left, right, next; 
 * 	TreeLinkNode(int x) { 
 * 		val = x; 
 * 	} 
 * }
 */

public class PopulateNextRightPointerII {
	public void connect(TreeLinkNode root) {

		// Time Complexity: O(N)
		// Space Complexity: O(1)

		if (root == null)
			return;

		TreeLinkNode p = root.next;
		
		while (p != null){
			if(p.left != null) {
				p = p.left;
				break;
			}
			if(p.right != null){
				p = p.right;
				break;
			}
			p = p.next;
		}
		
		if(root.right != null){
			root.right.next = p;
		}
		
		if(root.left != null){
			root.left.next = (root.right == null) ? p : root.right;
		}
		
		connect(root.right);
		connect(root.left);
	}
	
	class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
}
