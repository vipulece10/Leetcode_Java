class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<Integer,Integer>();
        PriorityQueue <Integer> pq=new PriorityQueue<Integer>((a,b)->(map.get(a)-map.get(b)));
        
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],1+map.get(nums[i]));
            }
            else{
                map.put(nums[i],1);
            }
        }
        
        for(Integer key:map.keySet()){
            pq.add(key);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        int[] res=new int[k];
        int i=0;
        while(pq.size()>0){
           res[i++]=pq.poll();
           
        }
        return res;
    }
}