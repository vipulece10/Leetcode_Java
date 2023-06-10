class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] seen = new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        return dfs_helper(graph,source,destination,seen);
    }
    
    public boolean dfs_helper(List<List<Integer>> graph,int source,int destination,boolean[]seen){
        if(source == destination)
            return true;
        if(!seen[source]){
            seen[source] = true;
        for(int node : graph.get(source)){
            if(dfs_helper(graph,node,destination,seen))
                return true;
        }
        }    
        return false;
    }
}