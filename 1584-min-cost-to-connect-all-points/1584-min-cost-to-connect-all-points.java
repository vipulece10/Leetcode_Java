class Solution {
    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        PriorityQueue<int[]> pq =new PriorityQueue<>((a,b) ->a[2] - b[2]);
        pq.add(new int[]{0,0,0});
        
        Set<Integer> visited = new HashSet<Integer>();
        int nums = points.length;
        
        while(!pq.isEmpty() && visited.size() != nums){
            int []curr = pq.poll();
            int endId = curr[1];
            int currCost = curr[2];
            
            if(visited.contains(endId))
                continue;
            
            visited.add(endId);
            cost+=currCost;
            
            for(int i =0;i<nums;i++){
                if(!visited.contains(i))
                pq.add(new int[]{endId,i,manhattandistance(points,endId,i)});
            }
            
        }
        return cost;
    }
    
    public int manhattandistance(int[][] points,int i,int j){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
}