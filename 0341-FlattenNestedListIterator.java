/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

//    List<NestedInteger> nestedList;
    Stack<Iterator<NestedInteger>> st = new Stack<Iterator<NestedInteger>>();
    NestedInteger cur = null;
    Iterator<NestedInteger> iter;
    Integer nextVal = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        iter = nestedList.iterator();
    }

    @Override
    public Integer next() {
        int result = nextVal;
        nextVal = null;
        hasNext();
        return result;
    }
    
    @Override
    public boolean hasNext() {
        if(nextVal!=null) {
            return true;
        } else {
            if(iter.hasNext()) {
                cur = iter.next();
                if(cur.isInteger()) {
                    nextVal = cur.getInteger();
                    return true;
                } else {
                    if(iter.hasNext()) {
                        st.push(iter);
                    }
                    iter = cur.getList().iterator();
                    return hasNext();
                }
            } else {
                if(!st.isEmpty()) {
                    iter = st.pop();
                    return hasNext();
                } else {
                    return false;
                }
            }
        }
    }
}
/**
[[1,1],2,[1,1]]
[1,[4,[6]]]
[]
[[]]
[[],3]
**/
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
