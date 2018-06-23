# leetCodeclass LRUCache {

    // free capacity
    int remaining;
    
    // map of values
    int[] values;
    
    // linked list, ordered with LRU at end.
    LinkNode lnHead; // first node
    LinkNode lnTail; // last node
    
    public LRUCache(int capacity) {
        values = new int[capacity];
        remaining = capacity;
    }
    
    public int get(int key) {
        
    }
    
    public void put(int key, int value) {
        // is it new, or already exists?
        LinkNode gln = getLn(int); // todo
        if(gln != null) {
            // exists
            gln.value = value;
            moveToHead(gln);
        } else {
            //new
            if(remaining == 0) {
                // overwrite tail
                LinkNode ln = lnTail;
                ln.value = value;
                if(ln.prev!=null) {
                    ln.prev.next = null;
                    lnTail = ln.prev;
                }
                moveToHead(ln)
            } else {
                remaining--;
                // always put at front of link list
                LinkNode ln = new LinkNode(value);
                moveToHead(ln);
        }
    }
    
    private void moveToHead(LinkNode ln) {
        if(ln==lnHead) {
            return;
        }
        if(ln.prev!=null) {
            ln.prev.next = ln.next;
        }
        if(ln.next!=null) {
            ln.next.prev = ln.prev;
        }
        ln.next = lnHead;
        lnHead.prev = ln;
        lnHead = ln;
    }
    
    public class LinkNode {
        int value;
        LinkNode next;
        LinkNode prev;
        
        public LinkNode(int value) {
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
