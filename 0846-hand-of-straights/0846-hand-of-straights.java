class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        /*
        hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
        map -> 1->1
               2->2
               3->2
               4->1
               6->1
               7->1 
               8->1
          
          pq [1,2,3,4,6,7,8]
        */
          
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0;i<hand.length;i++){
            if(!map.containsKey(hand[i])){
                map.put(hand[i],1);
                pq.add(hand[i]);
            }
            else{
                map.put(hand[i],map.get(hand[i]) + 1);
            }
        }
        
        while(!pq.isEmpty()){
            int num = pq.peek();
            for(int i=num;i<num+groupSize;i++){
             if(!map.containsKey(i) || map.get(i) == 0){ 
                 return false;
             }else{
                 int val = map.get(i);
                 map.put(i,val-1);
                 if(map.get(i) == 0){
                     if(pq.peek() != i)
                         return false;
                     pq.poll();
                 }
             }
            }
        }
        return true;
    }
}