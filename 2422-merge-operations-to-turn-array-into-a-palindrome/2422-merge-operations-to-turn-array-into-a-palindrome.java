class Solution {
    public int minimumOperations(int[] nums) {
        /*
        nums = [4,3,2,1,2,3,1]
                l.           h
               [4,3,2,3,2,4,1]
             l l   h
        */ 
        int low = 0;
        int high = nums.length - 1;
        int count = 0;
        while( low < high){
            if(nums[low] < nums[high]){
                nums[low + 1] = nums[low] + nums[low+1];
                count++;
                low++;
            }
            else if(nums[high] < nums[low]){
                nums[high - 1] = nums[high] + nums[high-1];
                count++;
                high--;
            }
            else{
                low++;
                high--;
            }
        }
        return count;
    }
}