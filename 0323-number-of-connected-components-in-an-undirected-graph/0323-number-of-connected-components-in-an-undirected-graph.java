class Solution {
    int [] parent;
    public int countComponents(int n, int[][] edges) {
        int cnt = n;
        parent = new int[n];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        
        for(int[] edge : edges){
            if(find(edge[0]) != find(edge[1])){
                
            union(edge[0],edge[1]);
            cnt--;
            }
        }
        
        return cnt;
    }
    
    public int find(int node){
        while(parent[node] != node){
            node = parent[node];
        }
        return node;
    }
    
    public void union(int node_i , int node_j){
        int rootNodei = find(node_i);
        int rootNodej = find(node_j);
        if(rootNodei != rootNodej ){
            parent[rootNodej] = rootNodei;
        }
    }
}