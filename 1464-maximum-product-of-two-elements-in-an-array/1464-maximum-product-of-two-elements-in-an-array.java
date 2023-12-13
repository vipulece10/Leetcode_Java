class Solution {
    public int maxProduct(int[] nums) {
        
        /*
         l
        [5,6,3,2]
    nl
        */
        
        int largest = 0;
        int nextLargest = 0;
        
        for(int i =0;i<nums.length;i++){
            if(nums[i] > largest){
                nextLargest = largest;
                largest = nums[i];
            }else{
                nextLargest = Math.max(nextLargest,nums[i]);
            }
        }
        return (largest - 1) * (nextLargest - 1);
    }
}