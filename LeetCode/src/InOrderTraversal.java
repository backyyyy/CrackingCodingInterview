import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Jan 16, 2015

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 * 		1
 * 		 \
 * 		  2
 * 		 /
 * 	    3
 * return [1,3,2].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 */

public class InOrderTraversal {
	
	// Method1: Recursive
	// Time Complexity: 
	// Space Complexity:
	
	public List<Integer> inorderTraversal(TreeNode root) {
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		doInorder(root,inOrder);
		return inOrder;
	}
	
	public void doInorder(TreeNode node, List<Integer> list){
		if(node == null) return;
		doInorder(node.left,list);
		list.add(node.val);
		System.out.print(node.val + " ");
		doInorder(node.right,list);
	}

	// Method2: Iterative
	// Time Complexity: 
	// Space Complexity:
	
	public List<Integer> inorderTraversal2(TreeNode root){
		ArrayList<Integer> inOrder = new ArrayList<Integer>();
		Stack<TreeNode> tmp = new Stack<TreeNode>();
		
		if(root == null) return inOrder; 

		TreeNode head = root;
		
		// My original code is:
		/**
		 * while(head != null || !tmp.isEmpty()){
				while(head != null){
					tmp.push(head);
					head = head.left;
				}
				
				head = tmp.pop();
				inOrder.add(head.val);
				head = head.right;
			}	
		return inOrder;
		
		However, this method is significantly slower. Why?
		*/
		
		while(true){
			while(head != null){
				tmp.push(head);
				head = head.left;
			}
			if(tmp.isEmpty()) break;
		
			head = tmp.pop();
			inOrder.add(head.val);
			System.out.print(head.val + " ");
			head = head.right;
		}	
		return inOrder;
	}

	public static void main(String[] args){
		
		InOrderTraversal test = new InOrderTraversal();
		
		TreeNode n7 = new TreeNode(68,null, null);
		TreeNode n8 = new TreeNode(75,null, null);
		TreeNode n4 = new TreeNode(40,null, null);
		TreeNode n5 = new TreeNode(70,n7, n8);
		TreeNode n6 = new TreeNode(150,null, null);
		TreeNode n2 = new TreeNode(55,n4, n5);
		TreeNode n3 = new TreeNode(120, null, n6);
		TreeNode n1 = new TreeNode(80,n2, n3);

		test.inorderTraversal(n1);
		System.out.println("");
		test.inorderTraversal2(n1);
	}
}

 class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int value, TreeNode left, TreeNode right) {
		val = value;
		this.left = left;
		this.right = right;
	}
	
	 TreeNode(int x) { val = x; }
}
