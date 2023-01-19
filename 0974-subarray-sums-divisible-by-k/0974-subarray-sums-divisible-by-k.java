class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int subarrayCount = 0;
        int currSum = 0;
        HashMap <Integer,Integer> hmap = new HashMap<>();
        hmap.put(0,1);
        for(int num : nums){
            currSum += num;
            int rem = currSum % k;
            if(rem < 0){
                rem += k;
            }
            if(hmap.containsKey(rem)){
                subarrayCount += hmap.get(rem);
                
            }
            hmap.put(rem,hmap.getOrDefault(rem,0) + 1);
        }
        
        return subarrayCount;
    }
}