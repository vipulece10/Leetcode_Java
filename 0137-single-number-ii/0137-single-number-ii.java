class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        //2,2,2,3
        //0,1,2,3
        for(int i =0;i<nums.length-1;i+=3){
            if(nums[i] == nums[i+1]){
                continue;
            }else{
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}