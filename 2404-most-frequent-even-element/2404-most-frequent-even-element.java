class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> hm =  new HashMap<>();
        int max_count = -1;
        int res = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
           if(nums[i] % 2 ==0){
               
               if(!hm.containsKey(nums[i])){
                   hm.put(nums[i],1);
               }
               else{
                   hm.put(nums[i],1+hm.get(nums[i]));
               }
               
               if(hm.get(nums[i]) > max_count){
                   max_count = hm.get(nums[i]) ;
                   res = nums[i];
               }
               else if(hm.get(nums[i]) == max_count){
                   res=Math.min(res,nums[i]);
               }
           } 
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}