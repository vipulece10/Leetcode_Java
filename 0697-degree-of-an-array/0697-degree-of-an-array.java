class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> firstSeen = new HashMap<>();
        HashMap<Integer,Integer> count = new HashMap<>();
        int degree = 0;
        int result = 0;
        
        for(int i = 0;i< nums.length;i++){
            firstSeen.putIfAbsent(nums[i],i);
            count.put(nums[i],count.getOrDefault(nums[i],0)+1);
           // degree = Math.max(degree,count.get(nums[i]));
            if(count.get(nums[i]) > degree){
                degree = count.get(nums[i]);
                //result = Math.max(result,i-firstSeen.get(nums[i]) + 1);
                result = i-firstSeen.get(nums[i]) + 1;
            }else if(count.get(nums[i]) == degree){
                result = Math.min(result,i - firstSeen.get(nums[i]) + 1);
            }
        }
        return result;
    }
}