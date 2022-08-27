class Solution {
    public int triangularSum(int[] nums) {
        int [] newNums = new int[nums.length-1];
        
        if(nums.length == 1)
            return nums[0];
        
        for(int i = 0;i < nums.length-1 ;i++ ){
            newNums[i] = (nums[i] + nums[i+1]) % 10;
        }
        
        int size = newNums.length-1;
        
        while(size !=0){
            for(int i =0 ;i< size;i++){
                newNums[i] = (newNums[i] + newNums[i+1]) % 10;
            }
            size--;
        }
        
        return newNums[0];
    }
}