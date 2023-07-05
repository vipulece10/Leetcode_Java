class Solution {
    public int longestSubarray(int[] nums) {
        /*
        //nums = [1,1,0,1]
        sliding window
        if(nums[j]==0){
        countOne++;
        }
        while(countOne > 1){
        i++;
        if(nums[i] == 0)
            countOne--;
        }
                 ^
        [0,1,1,1,0,1,1,0,1]
                       ^
         0,1,2,3,4,5,6,7,8
        
        res = 5      countone=1
        
        
        */
        int countZero = 0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            if(nums[i] == 0)
                countZero++;
        }
        if(countZero == 0)
            return nums.length -1;
        int i = 0,j =0;
        
        int countOne = 0;
        int res = 0;
        while(j < n){
            if(nums[j] ==0)
                countOne++;
            while(countOne > 1){
                if(nums[i] == 0)
                    countOne--;
                
                i++;
            }
            if(countOne == 1){
              res = Math.max(res,j-i);  
            }
            
            j++;
        }
        return res;
        
    }
}