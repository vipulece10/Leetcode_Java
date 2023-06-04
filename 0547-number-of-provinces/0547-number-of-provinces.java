class Solution {
    int[] par;
    int[] rank;
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        par = new int [n];
        rank = new int [n];
        int groups = n;
        for(int i =0;i<n;i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        for(int i =0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1){
                    groups -= union_find(i,j); 
                }
            }
        }
        return groups;
    }
    
    private int union_find(int i,int j){
        int p1 = find(i);
        int p2 = find(j);
        if(p1 == p2)
            return 0;
        
        if(rank[p1] > rank[p2]){
            par[p2] = p1;
            rank[p1] += rank[p2];
        }
        else{
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return 1;
    }
    
    private int find(int i){
        while(par[i] != i){
            i = par[i];
        }
        return i;
    }
}