class Solution {
    public boolean containsDuplicate(int[] nums) {
       //Solution 1
        /* int n=nums.length;
        boolean b=false;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                b=true;
            }
        }
        return b; */
       //Solution 2
        HashSet<Integer> set = new HashSet<>();
        for(int i =0; i<nums.length;i++){
            if(!set.add(nums[i])){
                return true;                
            }
        }
       
        return false;
    }
}