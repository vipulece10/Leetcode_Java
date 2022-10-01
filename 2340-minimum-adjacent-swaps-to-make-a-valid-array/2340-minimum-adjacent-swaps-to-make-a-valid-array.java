class Solution {
    /* 
    3 4 5 5 3 1
    1 3 3 4 5 5
    mismatch  1+1+1+1+1+1
    */
    public int minimumSwaps(int[] nums) {
        int minIndex = 0;
        int maxIndex = 0;
        
        for(int i =0;i< nums.length;i++){
            if(nums[i] < nums[minIndex]){
                minIndex = i;
            }
            if(nums[i] > nums[maxIndex]){
                maxIndex = i;
            }
            if(nums[i] == nums[maxIndex]){
                maxIndex = i;
            }
        }
        
        if(minIndex < maxIndex)
            return minIndex+ nums.length - 1-maxIndex;
        else if(minIndex == maxIndex)
            return 0;
        else{
            return minIndex+ nums.length - 2-maxIndex;
        }
    }
}