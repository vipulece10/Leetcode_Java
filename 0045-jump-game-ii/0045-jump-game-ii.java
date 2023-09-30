class Solution {
    public int jump(int[] nums) {
        
        int start = 0;
        int end =0;
        int jump=0;
        int farthest = 0;
        while(end < nums.length - 1){
            //int farthest = 0;
            for(int i=start;i<=end;i++){
                farthest = Math.max(farthest,i+nums[i]);
            }
            
            start = end+1;
            end = farthest;
            
            jump++;
            
        }
        return jump;
        
    }
}