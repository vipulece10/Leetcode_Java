class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        /*
        basket1 = [4,2,2,2],  [2,2,2,4]  2->2  4->0
        basket2 = [1,4,1,2]   [1,1,2,4]  1->2 
        */
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for(int i =0;i<basket1.length;i++){
            map.put(basket1[i],map.getOrDefault(basket1[i],0)+1);
            map.put(basket2[i],map.getOrDefault(basket2[i],0)-1);
        }
        
        for(int k : map.keySet()){
            min = Math.min(min,k);
            int diff = Math.abs(map.get(k));
            if(diff == 0) continue;
            if(diff % 2 !=0)
                return -1;
            
            for(int i =0;i<diff/2;i++){
                arr.add(k);
            }
        }
        
        if(arr.size() %2 != 0)
            return -1;
        Collections.sort(arr);
        for(int i = arr.size()/2 - 1;i>=0;i--){
            sum += Math.min(2*min,arr.get(i));
        }
        
        return sum;
    }
}