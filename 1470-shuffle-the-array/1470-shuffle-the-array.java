class Solution {
    public int[] shuffle(int[] nums, int n) {
        int [] ans = new int[2*n];
        for(int j=0,i=0;i<n;i++,j++){
            ans[j] = nums[i];
            ans[++j] = nums[i+n]; 
        }
        return ans;
    }
}