class Solution {
    //int [] ans;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int [] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean [] visited = new boolean[n];
        int [] ans = new int[n];
        dfs(graph, ans, labels, visited, 0);
        return ans;
    }
    
    private int [] dfs(List<List<Integer>> graph, int [] ans, String labels, boolean [] visited, int src){
        int [] count = new int[26];
        visited[src] = true;
        for(int nbr : graph.get(src)){
            if(visited[nbr] == false){
                int [] res = dfs(graph, ans, labels, visited, nbr);
                for(int i = 0; i < 26; i++){
                    count[i] += res[i];
                }
            }
        }
        char ch = labels.charAt(src);
        count[ch - 'a']++;
        ans[src] = count[ch - 'a'];
        return count;
    }
}

        
        
    
