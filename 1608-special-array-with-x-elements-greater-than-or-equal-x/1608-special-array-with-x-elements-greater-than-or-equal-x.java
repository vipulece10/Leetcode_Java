class Solution {
    public int specialArray(int[] nums) {
        /*
        [0,4,3,0,4]
        5/2 = 2 
        
        */
        int n = nums.length;
        
        int low = 0;
        int high = n;
        
        while(low <= high){
            int mid = low +(high - low)/2;
            if(countGreaterOrEqual(nums,mid) == mid)
                return mid;
            else if(countGreaterOrEqual(nums,mid) < mid)
            {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }
    
    public int countGreaterOrEqual(int[]nums,int mid){
        int count = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] >= mid){
                count++;
            }
        }
        return count;
    }
}