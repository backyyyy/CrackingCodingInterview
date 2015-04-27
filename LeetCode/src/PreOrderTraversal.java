import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Jan 16, 2015

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * 	Given binary tree {1,#,2,3},
 * 		1
 * 		 \
 * 		  2
 * 		 /
 * 	    3
 * return [1,2,3]
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */			

public class PreOrderTraversal {
	
	// Method1: Recursive
	// Time Complexity: O(N) --> Every notes are visited once
	// Space Complexity: O(N) --> List is O(N) space
	
	public List<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		doPreorder(root,preOrder);
		return preOrder;
    }
	
	public void doPreorder(TreeNode node, ArrayList<Integer> list){
		if(node == null) return;
		list.add(node.val);
		System.out.print(node.val + " ");
		doPreorder(node.left,list);
		doPreorder(node.right,list);		
	}
	
	// Method2: Iterative
	// Time Complexity: O(N) --> Every time is visited constant time
	// Space Complexity: O(logN) --> Every layer has at most one element in stack
	
	public List<Integer> preorderTraversal2(TreeNode root) {
		ArrayList<Integer> preOrder = new ArrayList<Integer>();
		Stack<TreeNode> tmp = new Stack<TreeNode>();
		
		if(root == null) return preOrder;
		
		tmp.push(root);
		TreeNode head = root;
		
		while(!tmp.isEmpty()){
			head = tmp.pop();
			preOrder.add(head.val);
			System.out.print(head.val + " ");
			
			if(head.right != null){
				tmp.push(head.right);
			}
			
			if(head.left != null){
				tmp.push(head.left);		
			}
		}
		return preOrder;		
	}
	
	public static void main(String[] args) {
		// 1. Null or empty tree;
		// 2. Only one element in the tree;
		// 3. All the way to the right and too deep -> Stack overflow?
		// 4. ?
		PreOrderTraversal test = new PreOrderTraversal();
		
		TreeNode n7 = new TreeNode(68,null, null);
		TreeNode n8 = new TreeNode(75,null, null);
		TreeNode n4 = new TreeNode(40,null, null);
		TreeNode n5 = new TreeNode(70,n7, n8);
		TreeNode n6 = new TreeNode(150,null, null);
		TreeNode n2 = new TreeNode(55,n4, n5);
		TreeNode n3 = new TreeNode(120, null, n6);
		TreeNode n1 = new TreeNode(80,n2, n3);
		
		test.preorderTraversal(n1);
		System.out.println("");
		test.preorderTraversal2(n1);
	}

}
//
//class TreeNode{
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x, TreeNode left, TreeNode right) {
//		val = x;
//		this.left = left;
//		this.right = right;}
//}
