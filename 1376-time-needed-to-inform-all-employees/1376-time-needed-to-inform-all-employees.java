class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i = 0;i<manager.length;i++){
            if(manager[i] != -1){
                adj.get(manager[i]).add(i);
            }
        }
        
        int [] max = {0};
        int [] time = {0};
        
        dfsHelper(adj,headID,max,time,informTime);
        return max[0];
    }
    
    private void dfsHelper(List<List<Integer>> adj,int headID,int[]max,int[]time,int[]informTime){
        max[0] = Math.max(max[0],time[0]);
        
        for(int emp : adj.get(headID)){
            time[0] += informTime[headID];
            dfsHelper(adj,emp,max,time,informTime);
            time[0] -= informTime[headID];
        }
    }
}