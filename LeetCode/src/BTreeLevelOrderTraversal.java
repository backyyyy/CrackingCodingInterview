import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


// May 16, 2015

/**
 * Given a binary tree, return the level order traversal of its nodes' 
 * values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * confused what "{1,#,2,3}" means? > read more on how binary tree is 
 * serialized on OJ.
 */

public class BTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(root == null) return result;
    	levelOrderTraversal(root,result,1);    	
    	return result;
    }
    
    public void levelOrderTraversal(TreeNode tn, List<List<Integer>> result, int depth) {
    	if(tn == null) return;
    	List<Integer> tempSet;
    	
    	if(result.size() < depth) {
    		tempSet = new ArrayList<Integer>();
    		result.add(tempSet);
    	} else {
    		tempSet = result.get(depth - 1);
    	}
    	
    	tempSet.add(tn.val);
    	levelOrderTraversal(tn.left, result, depth + 1);
    	levelOrderTraversal(tn.right, result, depth + 1);   	
    }
    
}
