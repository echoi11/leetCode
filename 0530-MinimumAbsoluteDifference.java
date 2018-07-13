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
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        int min = Integer.MAX_VALUE;
        int prevNum = 0;
        boolean isFirst = true;

        TreeNode n = root;
        do {
            if(n.left != null) {
                s.push(n);
                n = n.left;
            } else {
                if(isFirst) {
                    isFirst = false;
                } else {
                    min = Math.min(min, n.val - prevNum);
                }
                prevNum = n.val;
                //System.out.println(n.val);
                if(n.right!=null) {
                    n = n.right;
                } else {
                    if(!s.isEmpty()) {
                        n = s.pop();
                        n.left = null;
                    } else {
                        break;
                    }
                }
            }
        } while(true);
        return min;
    }
}
