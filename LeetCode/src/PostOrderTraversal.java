import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Jan 27, 2015;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example: Given binary tree {1,#,2,3}, 
 * 		1 
 * 		 \ 
 * 		  2 
 * 		 / 
 * 		3
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class PostOrderTraversal {

	// Method1: Recursive
	// Time Complexity: O(N) --> Every notes are visited once
	// Space Complexity: O(N) --> List is O(N) space
	
	public List<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		doPostOrder(root, postOrder);
		return postOrder;
	}

	public void doPostOrder(TreeNode node, ArrayList<Integer> list) {
		if (node == null)
			return;
		doPostOrder(node.left, list);
		doPostOrder(node.right, list);
		list.add(node.val);
		System.out.print(node.val + " ");
	}
	
	public List<Integer> postorderTraversal2(TreeNode root){
		ArrayList<Integer> postOrder = new ArrayList<Integer>();
		Stack<TreeNode> tmp = new Stack<TreeNode>();
		
		if(root == null) return postOrder;
		
		tmp.push(root);
		TreeNode head = root;
		
		while(!tmp.isEmpty()){	
//			head = tmp.peek();
			while(head != null){
				if(head.right != null) tmp.push(head.right);
				if(head.left != null) tmp.push(head.left);		
				head = head.right;
			}
			head = tmp.pop();
			postOrder.add(head.val);
			System.out.print(head.val + " ");

		}
		
		return postOrder;
	}
	
	public static void main(String[] args) {
		// 1. Null or empty tree;
		// 2. Only one element in the tree;
		// 3. All the way to the right and too deep -> Stack overflow?
		// 4. ?
		
		PostOrderTraversal test = new PostOrderTraversal();
		
		TreeNode n7 = new TreeNode(68,null, null);
		TreeNode n8 = new TreeNode(75,null, null);
		TreeNode n4 = new TreeNode(40,null, null);
		TreeNode n5 = new TreeNode(70,n7, n8);
		TreeNode n6 = new TreeNode(150,null, null);
		TreeNode n2 = new TreeNode(55,n4, n5);
		TreeNode n3 = new TreeNode(120, null, n6);
		TreeNode n1 = new TreeNode(80,n2, n3);
		
		test.postorderTraversal(n1);
		System.out.println("");
		test.postorderTraversal2(n1);
	}
}
