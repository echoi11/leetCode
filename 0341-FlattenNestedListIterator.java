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
    Stack<List<NestedInteger>> st = new Stack<List<NestedInteger>>();
    Stack<Integer> ist = new Stack<Integer>();
    List<NestedInteger> cur = null;
    int index = -1;
    Integer nextVal = null;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        cur = nestedList;
        index = 0;
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
            if(index >= cur.size()) {
                if(!st.isEmpty()) {
                    cur = st.pop();
                    index = ist.pop();
                    return hasNext();
                } else {
                    return false;
                }
            } else if(cur.get(index).isInteger()) {
                nextVal = cur.get(index++).getInteger();
                while(index >= cur.size() && !st.isEmpty()) {
                    System.out.println("popping...");
                    cur = st.pop();
                    index = ist.pop();
                }
                return true;
    //            System.out.println("int index=" + index);
            } else {
    //            System.out.println("list index=" + index);
                if(index < cur.size() - 1) {
                    st.push(cur);
                    ist.push(index+1);
                }
                cur = cur.get(index).getList();
                index=0;
                return hasNext();
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
