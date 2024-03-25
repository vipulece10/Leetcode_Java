class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        
        /*      0  1  2  3  4  5  6  7
        nums = [4 ,-3 ,-2 ,-7 ,8 ,2 ,-3 ,-1]
        */
        
        List<Integer> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            if(nums[Math.abs(nums[i]) - 1] < 0){
                res.add(Math.abs(nums[i]));
            }else{
                nums[Math.abs(nums[i])-1] = -1 * nums[Math.abs(nums[i]) - 1]; 
            }
        }
        return res;
    }
}