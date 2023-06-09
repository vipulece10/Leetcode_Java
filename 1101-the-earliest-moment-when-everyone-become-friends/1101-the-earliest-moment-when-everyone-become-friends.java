class Solution {
    int[] parent;
    int[] rank;
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a,b)->a[0] - b[0]);
        //int n = logs.length;
        parent = new int[n];
        rank = new int[n];
        
        for(int i =0;i<n;i++){
            parent[i] =i;
            rank[i] = 1;
        }
        
        for(int i=0;i<logs.length;i++){
            if(union(logs[i][1],logs[i][2],parent,rank)){
                n--;
                if(n==1)
                    return logs[i][0];
            }
        }
        return -1;
    }
    
    public boolean union(int i, int j,int[]parent,int[]rank){
        int pi = find(i,parent);
        int pj = find(j,parent);
        
        if(pi != pj){
            if(rank[pi] > rank[pj]){
                parent[pj] = pi;
                rank[pi] += rank[pj]; 
            }else{
                parent[pi] = pj;
                rank[pj] += rank[pi];
            }
            return true;
        }
        return false;
    }
    
    public int find(int x,int[] parent){
        while(x!=parent[x]){
            x = parent[x];
        }
        return x;
    }
}