class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int [] res = new int[nums.length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            if(a[1] == b[1]){
                return b[0]-a[0];
            } 
            else{
                return a[1]-b[1];
            }
        });
        
        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        
        for(int key : map.keySet()){
            pq.add(new int[]{key,map.get(key)});
        }
        
        int idx = 0;
        while(pq.size() > 0){
            int [] pair = pq.poll();
            while(pair[1] > 0){
                res[idx] = pair[0];
                idx++;
                pair[1]--;
            }
        }
        return res;
    }
}