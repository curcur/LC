/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
/** 
 * Depth-First
 */
/*public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();    // map of new GraphNode
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    
        if (node == null)   return null;
        if (map.containsKey(node.label))    return map.get(node.label);
        UndirectedGraphNode newnode = new UndirectedGraphNode(node.label);
        map.put(newnode.label, newnode);
        for (UndirectedGraphNode n : node.neighbors) {
            // XXXXXX SLEF LOOP!!!!!!!!!
            if (n.label == newnode.label) newnode.neighbors.add(map.get(newnode.label));
            else newnode.neighbors.add(cloneGraph(n)); 
        }
        return newnode;
    }
}*/

/**
 * Breadth-First
 */
public class Solution {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    Queue<UndirectedGraphNode> q = new LinkedList<>();  // the original nodes that have not copied neighbors
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)   return null;
        UndirectedGraphNode head = new UndirectedGraphNode(node.label);
        UndirectedGraphNode ocurr = node, curr = head;
        map.put(curr.label, curr);
        
        while(ocurr != null) {
            curr = map.get(ocurr.label);
            for(UndirectedGraphNode n : ocurr.neighbors) {
                if (!map.containsKey(n.label))   {
                    map.put(n.label, new UndirectedGraphNode(n.label)); 
                    q.offer(n); 
                }
                curr.neighbors.add(map.get(n.label));
            }
            ocurr = q.poll();
        }
        return head;
    }
} 
 
