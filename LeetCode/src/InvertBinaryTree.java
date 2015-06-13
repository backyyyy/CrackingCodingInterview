import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// Jun 12, 2015

/**
 * Invert a binary tree.
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 * 
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */

public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	TreeNode temp = new TreeNode(-1);
        	if(node.left != null) {
        		stack.push(node.left);
        	}
        	
        	if(node.right != null) {
        		stack.push(node.right);
        	}
        	
        	temp = node.left;
        	node.left = node.right;
        	node.right =temp;
        }        
        return root;
    }
}
