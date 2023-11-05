class Solution {
    public int removeDuplicates(int[] nums) {
        // Approach 1
//         for(int i =0;i<nums.length-1;i++){
//             if(nums[i] == nums[i+1]){
//                 nums[i] = Integer.MIN_VALUE;
//             }
//         }
        
//         int index = 0;
//         int start =0;
//         int end = nums.length -1;
//         while(start <= end){
//             if(nums[start] != Integer.MIN_VALUE){
//                 nums[index] = nums[start];
//                 index++;
//             }
//             start++;
//         }
//         return index;
        
        // Approach 2
        int index = 0;
        int i;
        for(i = 0;i<nums.length-1;i++){
            while(i < nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
            nums[index] = nums[i];
            index++;
        }
        if(i != nums.length){
        nums[index] = nums[nums.length-1];
        index++;
        }
        
        return index;
    }
}