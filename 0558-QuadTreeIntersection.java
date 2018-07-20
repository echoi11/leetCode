/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    public Node() {}

    public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};
*/
class Solution {
    public Node intersect(Node quadTree1, Node quadTree2) {
        return interNodes(quadTree1, quadTree2);
    }
    
    public Node interNodes(Node t1, Node t2) {
        Node res = new Node();
        if((t1.isLeaf && t1.val) || (t2.isLeaf && t2.val)) {
            res.isLeaf = true;
            res.val = true;
        } else if (t1.isLeaf && t2.isLeaf) {
            res.isLeaf = true;
            res.val = (t1.val || t2.val);
        } else if(t1.isLeaf) {
            res = t2;
        } else if(t2.isLeaf) {
            res = t1;
        } else { // both not leaf
            res.topLeft = interNodes(t1.topLeft, t2.topLeft);
            res.topRight = interNodes(t1.topRight, t2.topRight);
            res.bottomRight = interNodes(t1.bottomRight, t2.bottomRight);
            res.bottomLeft = interNodes(t1.bottomLeft, t2.bottomLeft);
        }
        if(!res.isLeaf) {
            res.val = false;
            if(res.topLeft.isLeaf && res.topRight.isLeaf && res.bottomRight.isLeaf && res.bottomLeft.isLeaf) {
                if(res.topLeft.val && res.topRight.val && res.bottomRight.val && res.bottomLeft.val) {
                    res = new Node();
                    res.val = true;
                    res.isLeaf = true;
                } else if(!res.topLeft.val && !res.topRight.val && !res.bottomRight.val && !res.bottomLeft.val) {
                    res = new Node();
                    res.val = false;
                    res.isLeaf = true;
                }
            }
            // res.val = res.topLeft.val || res.topRight.val || res.bottomRight.val || res.bottomLeft.val;
        }
        return res;
    }
}
