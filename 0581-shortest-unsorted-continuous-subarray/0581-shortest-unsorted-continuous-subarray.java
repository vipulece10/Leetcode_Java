class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        
        for(int i =1;i<nums.length;i++){
            if(nums[i-1] > nums[i]){
                minValue = Math.min(minValue,nums[i]);
            }
        }
        
        for(int i =nums.length -1;i>=1;i--){
            if(nums[i-1] > nums[i]){
                maxValue = Math.max(maxValue,nums[i-1]);
            }
        }
        
        if(maxValue == Integer.MIN_VALUE && minValue == Integer.MAX_VALUE)
            return 0;
        //System.out.println(minValue + " " + maxValue);
        
        int startIndex =0;
        int endIndex = nums.length-1;
        for(;startIndex<nums.length;startIndex++){
            if(nums[startIndex] > minValue)
                break;
        }
        
        for(;endIndex>=0;endIndex--){
            if(nums[endIndex] < maxValue)
                break;
        }
        
        return endIndex - startIndex + 1;
    }
}