class Solution {
     int res;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        res = 0;
        List<Integer>[] graph = new List[n];
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<n;i++)
            graph[parent[i]].add(i);
        dfs(0,graph,s,-1);
        return res;
    }
    
    public int dfs(int node,List<Integer>[] graph,String s,int parent){
        int max = 0, smax = 0;
        for (int child : graph[node]) {
            if (child == parent) {
                continue;
            }
            int maxFromChild = dfs(child, graph, s, node);
            if (s.charAt(child) == s.charAt(node)) {
                continue;
            }
            if (maxFromChild > max) {
                smax = max;
                max = maxFromChild;
            }
            else if (maxFromChild > smax) {
                smax = maxFromChild;
            }
        }
        res = Math.max(res, max + smax + 1);
        return max + 1;
    }
}