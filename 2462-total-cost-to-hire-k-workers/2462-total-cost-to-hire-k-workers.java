class Solution {
    
    public long totalCost(int[] costs, int k, int candidates) {
        /*
        costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
        list = {17,12,10,2,7,2,11,20,8}
        hireCost = 0;
        n = list.size();
        k = 1
        pq<Integer> 
        for(int i =0;i<candidates;i++){
        pq.add(list.get(i))
        pq.add(list.get(n-1-i));
        }
        hireCost += pq.pop();
        */
        long hireCost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0])
                return a[1] - b[1];
            else
                return a[0] - b[0];
        });
            
          //fill first k candidates in priority Queue
          for(int i=0;i<candidates;i++){
              pq.add(new int[]{costs[i],0});
          }
          //fill last k candidates in priority Queue
          for(int i=Math.max(candidates,costs.length - candidates);i<costs.length;i++){
              pq.add(new int[]{costs[i],1});
          }
          
         int headNext = candidates;
        int tailNext = costs.length - candidates -1;
          for(int i =0;i<k;i++){
              int[] curWorker = pq.poll();
              int curCost = curWorker[0];
              int curSecId = curWorker[1];
              hireCost += curCost;
              if(headNext <= tailNext){
                  if(curSecId == 0){
                      pq.add(new int[]{costs[headNext],0});
                      headNext++;
                  }
                  else{
                      pq.add(new int[]{costs[tailNext],1});
                      tailNext--;
                  }
              }
          }
         return hireCost;   
    }
}