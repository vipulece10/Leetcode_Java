class Solution {
    
    
    /*
    [1,0,1,1,1]  low =0, high = 4
    mid =2
    
    */
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        
        
        while(low <= high){
            while( low < high && nums[low] == nums[low + 1]){
                        low++;
                    }
            while( low < high && nums[high] == nums[high - 1]){
                        high--;
                    }
            
            int mid = low + (high - low)/2;
            if (nums[mid] == target)
                return true;
            
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                   
                }
                else{
                    low = mid + 1;
                }
                
            }
            // 7(low) 6 5(mid) 4 3 2 
            else{
                if( target <= nums[high] && target > nums[mid]){
                    low = mid + 1;
                    
                }
                else{
                    high = mid - 1;
                }
                
            }
        }
        return false;
    }
}