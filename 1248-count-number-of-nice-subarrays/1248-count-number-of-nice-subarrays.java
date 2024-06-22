class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        /*                           i        
         [2, 2, 2, 1, 2, 2, 1, 2, 2, 2]
                                  
        [{0->4},{1->3},{2->4}]
         
         res = 4+4+4+4
        */
        int count = 0;
        int niceSubArrays = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i = 0;i<nums.length;i++){
            count += (nums[i] % 2);
            if(map.containsKey(count - k)){
                niceSubArrays += map.get(count - k);
            }
            map.put(count,map.getOrDefault(count,0)+1);
        }
        return niceSubArrays;
    }
}