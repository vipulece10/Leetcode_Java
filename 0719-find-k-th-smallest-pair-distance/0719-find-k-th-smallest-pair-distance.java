class Solution {
    /*
    https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109075/Java-solution-Binary-Search
    https://youtu.be/BZpF_o60STI
    */
    
    
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n-1] - nums[0];
        
        while(low < high){
            int mid = low + (high - low)/2;
            if(countPairs(nums,mid) < k){
                low = mid+1;
            } 
            else{
                high = mid;
            }
        }
        return low;
    }
    
    public int countPairs(int[] nums,int mid){
        int l = 0;
        int r = 1;
        int count = 0;
        while(r < nums.length){
            if(nums[r] - nums[l] <= mid){
                count += r - l;
                r++;
            }else{
                l++;
            }
        }
        return count;
    }
}