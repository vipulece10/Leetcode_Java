class Solution {
    public int splitArray(int[] nums, int m) {
        int total =0;
        int l;
        int max=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            max=Math.max(max,nums[i]);
        }
        l=max;
        int h=total;
        int mid,ans=0;
        while(l <= h){
            mid=l+(h-l)/2;
            if(verify(nums,mid,m)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    
    public boolean verify(int[] nums,int mid,int m){
        int count=1;
        int sum=0;
        boolean flag;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>mid){
                count+=1;
                sum=nums[i];
                
            }
            if(count > m)
                return false;
        }
        return true;
    }
}