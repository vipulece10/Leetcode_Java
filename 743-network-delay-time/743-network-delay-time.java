class Solution {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<int[]>> adj = new HashMap<>();
        for(int[]time :times){
            int source = time[0];
            int destination = time[1];
            int time_taken = time[2];
            adj.putIfAbsent(source,new ArrayList<>());
            adj.get(source).add(new int [] {destination,time_taken});
        }
        int answer = 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<int[]>pq=new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{k,0});
        
        while(!pq.isEmpty()){
            int [] curr = pq.poll();
            int node = curr[0];
            int cost = curr[1];
            
            if(visited.contains(node))
                continue;
            
            visited.add(node);
            answer = Math.max(answer,cost);
            
            if(!adj.containsKey(node))
                continue;
            
            for(int[] neighbour: adj.get(node)){
                pq.offer(new int[]{neighbour[0], neighbour[1] + cost});
            }
            

        }
        
        return visited.size() == n ? answer : -1;
        
        
        
        
        
    }
    
    
 }