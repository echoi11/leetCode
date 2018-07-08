/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	HashSet<MyNode> set = new HashSet<MyNode>();
	HashSet<MyNode> tset = new HashSet<MyNode>();
	Stack<MyNode> pNodes;
	Queue<MyNode> dNodes;
	
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
    	
    	pNodes = new Stack<MyNode>();
    	dNodes = new LinkedList<MyNode>();
    	dNodes.add(new MyNode(root, null, 0));
    	
    	MyNode mn;
    	int depth;
    	int maxDepth = 0;
    	while(!dNodes.isEmpty()) {
    		mn = dNodes.remove();
    		pNodes.push(mn);
    		depth = mn.depth;
    		maxDepth = depth;
    		if(mn.node.left!=null) {
    			dNodes.add(new MyNode(mn.node.left, mn, depth + 1));
    		}
    		if(mn.node.right!=null) {
    			dNodes.add(new MyNode(mn.node.right, mn, depth + 1));
    		}
    	}
    	
    	while(!pNodes.isEmpty()) {
    		mn = pNodes.pop();
    		if(mn.depth < maxDepth) {
    			break;
    		} else {
                set.add(mn);
    		}
    	}
    	
    	while(set.size() > 1) {
    		tset = new HashSet<MyNode>();
    		for(MyNode n : set) {
                if(n.parentNode !=null) {
        			tset.add(n.parentNode);
                } else {
                    tset.add(n);
                }
    		}
    		set = tset;
    	}
    	
    	for(MyNode n : set) {
    		return n.node;
    	}
    	return null;
        
    }
	
    private class MyNode {
    	TreeNode node;
    	int depth;
    	MyNode parentNode;
    	
    	MyNode(TreeNode node, MyNode parentNode, int depth) {
    		this.depth = depth;
    		this.node = node;
    		this.parentNode = parentNode;
    	}
    }
    
// 	private class TreeNode {
// 		int val;
// 		TreeNode left;
// 		TreeNode right;

// 		TreeNode(int x) {
// 			val = x;
// 		}
// 	}
}
