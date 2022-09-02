class Solution {
    public int removeDuplicates(int[] nums) {
        for(int i =0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] = Integer.MIN_VALUE;
            }
        }
        
        int index = 0;
        int start =0;
        int end = nums.length -1;
        while(start <= end){
            if(nums[start] != Integer.MIN_VALUE){
                nums[index] = nums[start];
                index++;
            }
            start++;
        }
        return index;
    }
}