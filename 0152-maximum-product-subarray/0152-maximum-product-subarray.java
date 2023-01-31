class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int currProd = 1;
        for(int i =0;i<nums.length;i++){
            currProd *= nums[i];
            max = Math.max(max,currProd);
            if(currProd == 0)
                currProd = 1;
        }
        currProd = 1;
        for(int i =nums.length - 1;i>=0;i--){
            currProd *= nums[i];
            max = Math.max(max,currProd);
            if(currProd == 0)
                currProd = 1;
        }
        return max;
    }
}