class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1)
            return false;
        int [] parent = new int [n];
        int [] rank = new int [n];
        
        for(int i =0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(int[] edge : edges){
            if(!union(edge[0],edge[1],parent,rank)){
                return false;
            }else{
                n--;
            }
        }
       return n==1 ? true: false; 
    }
    
    public boolean union(int i,int j,int[] parent,int[]rank){
        int iParent = find(i,parent);
        int jParent = find(j,parent);
        if(iParent == jParent)
            return false;
        if(rank[iParent] <= rank[jParent]){
            parent[jParent] = iParent;
            rank[iParent] += rank[jParent];
        }
        else{
            parent[iParent] = jParent;
            rank[jParent] += rank[iParent];
        }
        return true;
    }
    
    public int find(int x, int[]parent){
        while(x != parent[x]){
            x = parent[x];
        }
        return x;
    }
}