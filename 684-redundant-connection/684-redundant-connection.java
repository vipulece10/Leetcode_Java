class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
         parent = new int [edges.length + 1];
        for(int i =0;i< parent.length;i++){
            parent[i] = i;
        }
        
        for(int [] edge : edges){
            if(find(edge[0]) == find(edge[1]))
                return edge;
            
            union(edge[0],edge[1]);
        }
        return new int[]{-1,-1};
    }
    
    public int find(int node){
        while(parent[node] != node){
            node = parent[node];
        }
        return node;
    }
    
    public void union(int node_i,int node_j){
        int rootNode_i = find(node_i);
        int rootNode_j = find(node_j);
        if(rootNode_i != rootNode_j ){
            parent[rootNode_j] = rootNode_i;
        }
    }
    
}