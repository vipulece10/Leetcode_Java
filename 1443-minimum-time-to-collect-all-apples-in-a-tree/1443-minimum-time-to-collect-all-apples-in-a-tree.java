class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i =0; i< n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        return dfs(graph, 0, hasApple, -1);
    }
    
    private int dfs( HashMap<Integer, List<Integer>> graph, int node, List<Boolean> hasApple, int parent){
    int steps = 0, childSteps = 0;
        if(hasApple.get(node) && node != 0){
            steps += 2;
        }
        for(int nbr: graph.get(node)){
            if(nbr != parent){
                childSteps += dfs(graph, nbr, hasApple, node); 
            }
        }
        if(childSteps > 0 && steps == 0 && node != 0) steps = 2; 
        return steps + childSteps;

    }
}