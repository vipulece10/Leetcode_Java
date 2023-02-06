class Solution {
    public long pickGifts(int[] gifts, int k) {
        long res = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<gifts.length;i++){
            pq.add(gifts[i]);
        }
        
        while(k > 0){
            int remainingGifts = (int)Math.floor((Math.sqrt(pq.poll() * 1.0) * 1.0));
            pq.add(remainingGifts);
            k--;
        }
        
        while(!pq.isEmpty()){
            res += pq.poll();
        }
        return res;
    }
}