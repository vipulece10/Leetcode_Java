class Solution {
    public int[] getAverages(int[] nums, int k) {
        if(k == 0)
            return nums;
        int n = nums.length;
        if(k > n){
            //return new int[]{-1};
            Arrays.fill(nums,-1);
            return nums;
        }
        long [] sum = new long [n];
        sum [0] = nums[0];
        for(int i = 1;i<n;i++){
            sum[i] = nums[i] + sum[i-1]; 
        }
        
        int divisor = 2*k+1;
        int index = 0;
        for(int j = k ;j<n-k;j++){
            if(j > k){
                nums[j] = (int)((sum[j + k] - sum[index++])/divisor);
            }else{
                nums[j] = (int)(sum[2*k]/divisor);
            }
            System.out.print(j + " " + nums[j]);
        }
        for(int i =0;i<n;i++){
            if(i < k){
                nums[i] = -1;
            }
            if(i >= n - k){
                nums[i] = -1;
            }
        }
        return nums;
    }
}