Copy List with Random Pointer
    - A linked list is given such that each node contains an additional 
      random pointer which could point to any node in the list or null.
    - Return a deep copy of the list.

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

/**
 * There are three ways:
 * 1. Two Passes
 * - First pass: deep copy the next pointer
 * - Second pass: link the random pointer
 * - When linking the random pointer, we need to search for the copied node 
 *   for each random pointer, which O(n)
 * - Time Complexity: O(n^2) in total, and no extra space
 * 
 * 2. HashMap
 * - Instead of search for copied node for each random pointer,
 *   we hash the copied one for the original one:
 *   HashMap<Original, Copied>
 * - Time Complexity: O(n), and space O(n).
 * - We can further improve this to single pass:
 *   treating next and random pointer the same way
 */
 
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)   return null;
        
	// ori -> copied
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        
        RandomListNode chead = new RandomListNode(head.label);
        map.put(head, chead);
        RandomListNode cor = head, cur = chead;
        
        while(cor != null) {
            // next pointer 
            if (cor.next == null)  cur.next = null;
            else if (map.containsKey(cor.next))    
		cur.next = map.get(cor.next);
            else {  cur.next = new RandomListNode(cor.next.label);
                    map.put(cor.next, cur.next);
            }
            
            // random pointer
            if (cor.random == null)  cur.random = null;
            else if (map.containsKey(cor.random))    
		cur.random = map.get(cor.random);
            else {  cur.random = new RandomListNode(cor.random.label);
                    map.put(cor.random, cur.random);
            }
            
            cor = cor.next;
            cur = cur.next;
            
        }
        return chead;
    }
}


//------------------------------------------------------------------------------

/**
 * 3. O(n) time O(1) space
 * - Space or time is wasted for search for the copied node
 * - Avoid this by connecting the original node to the copied node
 */

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dhead = new RandomListNode(0), 
	    cur = dhead, cor = head, cornext = null;
        
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
