class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int pile : piles){
            pq.add(pile);
        }

        for(int i =0;i<k;i++){
            int number = pq.poll();
            int remove = number/2;
            pq.add(number - remove);
        }
        int ans =0;
        for(int num : pq){
            ans +=num ;
        }
        return ans;
    }
}