/**
 * ----------------------------------------------------------------------------
   Merge k Sorted Lists:
    - Merge k sorted linked lists and return it as one sorted list. 
    - Analyze and describe its complexity.
 * ----------------------------------------------------------------------------
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 **/

/**
 * Two ways: (two ways of join)
 * 1. Merge k lists together at a time, each list has n numbers 
 * - Each time, pick up the min from the k list
 * - Use a k-size min-heap O(logk) 
 * - Binary search is also OK, but heap is better
 * - Time complexity is O(nk*logk)
 * - Space Complexity is O(k)
 */
 
public class Solution {
    private final class Compare implements Comparator<ListNode> {
        public int compare(ListNode n0, ListNode n1) { return n0.val - n1.val; }
    }
    
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty())  return null;        
	
	// XXXX pq can not take 0 as input argument;
	// initialize the priorityqueue
        PriorityQueue<ListNode> pq = 
	    new PriorityQueue<ListNode>(lists.size(), new Compare());
        for(ListNode ln : lists) if(ln != null) pq.add(ln);

        ListNode dhead = new ListNode(0), cur = dhead;
        while (!pq.isEmpty()) { // the heap is not empty
            cur.next = pq.poll();   cur = cur.next;
            if (cur.next != null)   pq.add(cur.next);
        }
        return dhead.next;
    }
}


//------------------------------------------------------------------------------

/**
 * 2. Merge 2 lists together at a time.
 * - Each Round, the total number of elements merged is nk
 * - logk rounds in total
 * - Time Complexity is O(nk*logk)
 * - No additional space, since it is linked lists
 */

public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.isEmpty())  return null;    //XXXX list is empty
        
        int length = 0, i = 0;
        while(lists.size() > 1) {
            length = lists.size();
            for (i=0; i+1<length; i+=2) 
                lists.add(mergeLists(lists.get(i), lists.get(i+1)));
            if (i < length) lists.add(lists.get(i));   // odd
            for (i=0; i<length; i++)    lists.remove(0);
        }
        System.out.println(lists.size());
        
        return lists.get(0);
    }
    
    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dhead = new ListNode(0), cur = dhead;
        while (l1 != null && l2 != null) {
            if(l1.val < l2.val) { cur.next = l1; l1 = l1.next;}
            else { cur.next = l2; l2 = l2.next; }
            cur = cur.next;
        }
        
        ListNode tcur = (l1 == null) ? l2 : l1;  // tailing
        cur.next = tcur;
        return dhead.next;
    }
}
