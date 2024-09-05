class Solution {
    public int findMaxLength(int[] nums) {
        /*
        1,0,2,3,0
        0 1 2 3 4
        
        */
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        
        int maxLength = 0;
        int sum = 0;
        
        for(int i=0;i<nums.length;i++){
            sum += nums[i] ==1 ? 1 : -1;
            if(map.containsKey(sum)){
                maxLength = Math.max(maxLength,i-map.get(sum));
            }
            else{
                map.put(sum,i);
            }
        }
        return maxLength;
    }
}