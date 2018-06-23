public class LRUCache {

    // capacity
    int capacity;

    // free capacity
    int remaining;
    
    // map of values
    HashMap<LinkNode> map;
    
    // linked list, ordered with LRU at end.
    LinkNode lnHead; // first node
    LinkNode lnTail; // last node
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        remaining = capacity;
    }
    
    public void initLRU(int key, int value) {
        map = new HashMap<LinkNode>();
        LinkNode ln = new LinkNode(key, value);
        lnHead = ln;
        lnTail = ln;
        map.put(key, ln);
        remaining--;
    }
    
    public int get(int key) {
        LinkNode ln = getLn(key);
        if(ln==null) {
            return -1;
        } else {
            return ln.value;
        }
    }
    
    public LinkNode getLn(int key) {
        LinkNode ln = map.get(key);
        if(ln!=null) {
            moveToHead(ln);
            return ln;
        } else {
            return null;
        }
    }
    
    public void put(int key, int value) {
        if(capacity==remaining) {
            initLRU(key, value);
        }
        
        // is it new, or already exists?
        LinkNode gln = getLn(int);
        if(gln != null) { // already exists
            gln.value = value;
            // moveToHead(gln); // already done by getLn()
        } else {
            //new
            if(remaining == 0) {
                // overwrite tail
                map.remove(lnTail.key);
                LinkNode ln = lnTail;
                ln.key = key;
                ln.value = value;
                map.put(key, ln);
                moveToHead(ln);
            } else {
                remaining--;
                LinkNode ln = new LinkNode(key, value);
                map.put(key, ln);
                // always put at front of link list
                moveToHead(ln);
        }
    }
    
    private void moveToHead(LinkNode ln) {
        if(ln==lnHead) {
            return;
        }
        if(ln.prev!=null) {
            ln.prev.next = ln.next;
            if(ln == lnTail) {
                lnTail = ln.prev;
            }
        }
        if(ln.next!=null) {
            ln.next.prev = ln.prev;
        }
        ln.next = lnHead;
        lnHead.prev = ln;
        lnHead = ln;
    }
    
    public class LinkNode {
        int key;
        int value;
        LinkNode next;
        LinkNode prev;
        
        public LinkNode(int key, int value) {
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
