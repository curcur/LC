/**
 * There are three ways:
 * 1. Most Naive
 * first pass, deep copy the next pointer
 * second pass, link the random pointer
 * when fixing the random pointer, you need to search for the copied node for each random pointer, which O(n)
 * n nodes in total, so O(n^2) in total, and no extra space
 * 
 * 2. we can think of a map to hash the copied node for random pointer, so that you do not need to search
 * time O(n), but space is also O(n).
 * We can further improve this by just single pass, treating next and random pointer the same way
 * 
 * 3. Can we do O(n) time and O(1) space?
 * Those extra space and time are wasted for serching the random pointer node, we can avoid this by connecting
 * the original node to the copied node, so that when considering random pointer, we know where is the copied 
 * node directly.
 * 
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
/*public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<Integer, RandomListNode> hm = new HashMap<Integer, RandomListNode>();

        RandomListNode dhead = new RandomListNode(0), cur = dhead, cor = head;
        
        
        while(cor != null) {
            // next's copy
            if (hm.containsKey(cor.label))   cur.next = hm.get(cor.label);
            else { 
                cur.next = new RandomListNode(cor.label);
                hm.put(cor.label, cur.next);
            }
            cur = cur.next;
            
            // next's random's copy
            if (cor.random == null)  cur.random = null;
            else if (hm.containsKey(cor.random.label)) cur.random = hm.get(cor.random.label);
            else { 
                cur.random = new RandomListNode(cor.random.label);
                hm.put(cor.random.label, cur.random);
            }
            cor = cor.next;
        }
        
        return dhead.next;
    }
}*/

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dhead = new RandomListNode(0), cur = dhead, cor = head, cornext = null;
        
        // construct the copied list 
        while(cor != null) {
            cur.next = cor; cornext = cor.next; 
            cur = new RandomListNode(cor.label);
            cor.next = cur; cor = cornext;
        }
        
        // construct the random pointer
        cor = head;
        while(cor != null) {
            cor.next.random = (cor.random == null) ? null : cor.random.next;
            cor = cor.next.next;
        }
        
        // restore to the original state
        cor = head; cur = dhead;
        while(cor != null) {
            cur.next = cor.next;
            cor.next = cor.next.next;
            
            cor = cor.next; cur = cur.next;
        }
        
        return dhead.next;
    }
}
