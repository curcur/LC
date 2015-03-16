/**
 * Java's LinkedList does not work, because there is no way for it to get the pointer(reference directly).
 * Need double list, otherwise can not reEnter from the tail
 * Use a dummy head and dummy tail would better
 */
 
public class LRUCache {
    private class ValueLink{    // hashValue
        int value;
        LinkNode node;
        ValueLink(int value, LinkNode node) { this.value = value; this.node = node; }
    }
    
    private class LinkNode{     // doubleList
        int key;
        LinkNode next;
        LinkNode prev;
        LinkNode(int key) { this.key = key; next = null; prev = null; }
    }
    
    private class LinkList{
        LinkNode dhead;         // dummy head
        LinkNode dtail;         // dummy tail
        final int cap;          // capacity
        int curr;               // current length
        
        LinkList(int cap) {
            dhead = new LinkNode(-1); dtail = new LinkNode(-1);
            dhead.next = dtail; dtail.prev = dhead;
            this.cap = cap; this.curr = 0;
        }
        
        void reEnter(LinkNode node) {
            LinkNode prev = node.prev, next = node.next;
            prev.next = next;   next.prev = prev;
            offer(node);
        }
        
        Integer LRUInsert(LinkNode node) {
            offer(node);
            if (curr == cap) { // reach the capacity
                return poll().key;
            }else { curr++; return null; }
        } 
        
        void offer(LinkNode node) { 
            LinkNode prev = dtail.prev; prev.next = node; 
            node.prev = prev; node.next = dtail; dtail.prev = node;}
        LinkNode poll() { 
            if (dhead.next == dtail)    return null; // empty
            LinkNode head = dhead.next, next = head.next;
            dhead.next = next;  next.prev = dhead; return head; }
    }
    
    LinkList q;
    Map<Integer, ValueLink> map;
    
    public LRUCache(int capacity) {
        q = new LinkList(capacity);
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (map.containsKey(key))   {
            q.reEnter(map.get(key).node);
            return map.get(key).value;
        }
        else return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            q.reEnter(map.get(key).node);
        }
        else { 
            Integer pkey = q.LRUInsert(new LinkNode(key));
            if (pkey != null) map.remove(pkey);
            map.put(key, new ValueLink(value, q.dtail.prev));
        }
    }
    
}