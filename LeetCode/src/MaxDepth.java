// Jan 14, 2015

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the
 * longest path from the root node down to the farthest leaf node.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class MaxDepth {
	
	// Time Complexity: O(N)
	// Space Complexity: O(N)
	
	public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	public static void main(String[] args){
		// 1. Null tree
		// 2. Too large tree --> Exceed the max of int
		// 3. Tree with only left/right nodes (same as a LinkedList)
	}

}
