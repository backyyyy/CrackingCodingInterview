// Jan 14, 2015

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * 
 * Two binary trees are considered equal if they are structurally identical
 * and the nodes have the same value.
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		// Time Complexity: O(N) --> every nodes need to be compared once
		// Space Complexity: O(1) --> No new variables created
		
		if(p == null && q == null) return true;
		else if(p == null || q == null) return false;	
		
        return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right,q.right));
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
		// 2. 
	}
}

