class Solution {
    public int minimumCost(int n, int[][] connections) {
        //create graph
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int[] connection : connections){
            graph.putIfAbsent(connection[0],new ArrayList<>());
            graph.putIfAbsent(connection[1],new ArrayList<>());
            graph.get(connection[0]).add(new int[]{connection[1],connection[2]});
            graph.get(connection[1]).add(new int[]{connection[0],connection[2]});
        }
        int sum = 0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.add(new int [] {connections[0][0],0});
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            if(visited.contains(curr[0]))
                continue;
            visited.add(curr[0]);
            sum += curr[1];
            for(int [] next : graph.get(curr[0])){
                if(!visited.contains(next[0]))
                pq.add(new int[]{next[0],next[1]});
            }
            
        }
        return visited.size() == n ? sum : -1;
    }
}