class Solution {
    public int longestConsecutive(int[] nums) {
        //Solution 1
       /* if(nums.length==0) return 0;
        Arrays.sort(nums);
        int count=0,maxcount=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1==nums[i+1])
                count++;
            else{
                maxcount=Math.max(maxcount,count);
                count=0;
            }
        }
        maxcount=Math.max(maxcount,count);
        return maxcount+1; */
        
        //Solution 2
        if(nums.length == 0 || nums == null)
            return 0;
        HashSet <Integer> set = new HashSet<>();
        
        int maxcount = Integer.MIN_VALUE; 
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
        }
        
        for(int i =0;i<nums.length;i++){
            int count = 1;
            int num = nums[i];
            if(!set.contains(num-1)){
                while(set.contains(num+1)){
                    num++;
                    count++;
                }
            }
            maxcount = Math.max(maxcount,count);
        }
        return maxcount;
    }
}