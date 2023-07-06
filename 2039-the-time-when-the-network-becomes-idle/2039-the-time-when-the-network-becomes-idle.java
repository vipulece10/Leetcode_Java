class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        /*
        [[0,1],[0,2],[1,2]], patience = [0,10,10]
        0 -> 1,2
        1 -> 0,2
        2 -> 0,1
        */
        //create an adjacency matrix
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<patience.length;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[]edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int n = patience.length;
        int[]distance = new int[patience.length];        
        bfs(adj,distance,n);
        int ans = Integer.MIN_VALUE;
        for(int i=1;i<n;i++){
            //System.out.println(distance[i]);
            int pos = (2 * distance[i] - 1)/patience[i];
            int startingTime = pos * patience[i];
            int finalVal = startingTime + 2*distance[i];
            ans = Math.max(ans,finalVal); 
        }
        
        
        return ans + 1;
        
    }
    
    private void bfs(List<List<Integer>> adj,int [] distance,int n){
        boolean [] vis = new boolean[n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        distance[0] = 0;
        vis[0] = true;
        
        while(!q.isEmpty()){
            int [] top = q.poll();
            int curr = top[0];
            int dist = top[1];
            for(int node:adj.get(curr)){
                if(vis[node] != true){
                    q.add(new int[]{node,dist+1});
                    distance[node] = dist+1;
                    vis[node] = true;
                }
            }
        }
    }
}