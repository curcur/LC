/**
 * This is a question about topological sort
 * If there is a cycle, then no possible topological sort
 * - Good Practice for Topological Sorting
 * - DFS with label, BFS
 * - DFS mark from the end to the beginning, BFS mark from the beginning to the end
 */
 
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjLists = new List[numCourses];
        for(int i=0; i<numCourses; i++)
            adjLists[i] = new ArrayList<>();
        
        for(int i=0; i<prerequisites.length; i++) 
            adjLists[prerequisites[i][1]].add(prerequisites[i][0]);
        
	// 0: not visited yet; 1: pending; 2: visted
	// if a dfs visit a pending node, then a cycle is detected
        int[] visited = new int[numCourses];  
        for(int i=0; i<numCourses; i++) {
            if (visited[i] == 0)
                if (!dfs(i, adjLists, visited))
                    return false;
        }
        return true;
    }
    
    private boolean dfs(int node, List<Integer>[] adjLists, int[] visited) {
        visited[node] = 1;
        for(Integer i : adjLists[node]) {
            if(visited[i] == 0) {
                if(!dfs(i, adjLists, visited))
                	return false;
            }
	    // XXXX if not {}, this else if will match with the second if
            else if(visited[i] == 1)  
                return false;
        }
	// $$$$ here to add order, if return lists are required.
        visited[node] = 2;  
        return true;
    }
}

/**
 * BFS
 * int[] in_degree to record the in-degrees of each node 
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adjLists = new List[numCourses];
        for(int i=0; i<numCourses; i++)
            adjLists[i] = new ArrayList<>();
        
        for(int i=0; i<prerequisites.length; i++) 
            adjLists[prerequisites[i][1]].add(prerequisites[i][0]);
        
        // keep an in_degree array to look for all nodes with 0 in-degrees
        int[] in_degree = new int[numCourses];
        for(int i=0; i<numCourses; i++)
            for(int j : adjLists[i])
                in_degree[j]++;
               
        Queue<Integer> no_in_degree = new ArrayDeque<>();
        for(int i=0; i<numCourses; i++)
            if (in_degree[i] == 0)
                no_in_degree.offer(i);
        
        int count = numCourses;
        while(!no_in_degree.isEmpty()) {
            // $$$$ here to add order, if return lists are required
            int i = no_in_degree.poll();
            count--;
            for(int j : adjLists[i]) {
                in_degree[j]--;
                if (in_degree[j] == 0)
                    no_in_degree.offer(j);
            }
        }

        if (count > 0)
            return false;
        else 
            return true;
        
    }
}
