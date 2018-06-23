public class LFUCache {

    // capacity
    int capacity;

    // free capacity
    int remaining;
    
    // map of values
    HashMap<Integer, LinkNode> map;
    
    // linked list, ordered with LRU at end.
    LinkNode lnHead; // first node
    LinkNode lnTail; // last node
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        remaining = capacity;
    }
    
    public void init(int key, int value) {
        map = new HashMap<Integer, LinkNode>();
        LinkNode ln = new LinkNode(key, value);
        lnHead = ln;
        lnTail = ln;
        map.put(key, ln);
        remaining--;
    }
    
    public int get(int key) {
        if(capacity==remaining) {
            return -1;
        }
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
            ln.freq++;
            moveUp(ln);
            return ln;
        } else {
            return null;
        }
    }
    
    public void put(int key, int value) {
        if(capacity==0) {
            return;
        }
        if(capacity==remaining) {
            init(key, value);
            return;
        }
        
        // is it new, or already exists?
        LinkNode gln = getLn(key);
        if(gln != null) { 
            gln.value = value;
        } else {
            //new
            if(remaining == 0) {
                // overwrite tail
                map.remove(lnTail.key);
                LinkNode ln = lnTail;
                ln.freq = 0;
                ln.key = key;
                ln.value = value;
                map.put(key, ln);
                moveUp(ln);
            } else {
                remaining--;
                LinkNode ln = new LinkNode(key, value);
                // set as tail
                ln.prev = lnTail;
                lnTail.next = ln;
                lnTail = ln;
                map.put(key, ln);
                moveUp(ln);
            }
        }
    }
    
    private void moveUp(LinkNode ln) {
        if(ln==lnHead) {
            return;
        }

        LinkNode prevLn = ln.prev;
        while(prevLn!=null && prevLn.freq <= ln.freq) {
            prevLn = prevLn.prev;
        }
        if(prevLn == ln.prev) {
            return;
        }
        
        // pop ln
        ln.prev.next = ln.next;
        if(ln==lnTail) {
            lnTail = ln.prev;
        } else {
            ln.next.prev = ln.prev;
        }

        // insert ln
        if(prevLn==null) { // make ln the head node
            ln.prev = null;
            ln.next = lnHead;
            lnHead.prev = ln;
            lnHead = ln;
        } else {
            ln.next = prevLn.next;
            ln.prev = prevLn;
            prevLn.next = ln;
            ln.next.prev = ln;
        }
    }
    
    private class LinkNode {
        int key;
        int value;
        int freq=0;
        LinkNode next;
        LinkNode prev;
        
        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
        
        public String toString() {
            return "(" + key +","+value+","+freq+")";
        }
    }
    
    public void debug() {
        System.out.println("head=" + lnHead);
        System.out.println("tail=" + lnTail);
        LinkNode ln = lnHead;
        while(ln!=null) {
            System.out.println(ln);
            ln = ln.next;
        }
    }
    
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
