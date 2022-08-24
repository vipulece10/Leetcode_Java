class Solution {
    public int threeSumClosest(int[] nums, int target) {
        
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i =0 ; i < nums.length - 2;i++){
           int low = i+1;
           int high = nums.length - 1;
           while(low < high){
               int curr_sum = nums[i] + nums[low] + nums[high];
               
               if(curr_sum < target)
                   low++;
               else 
                   high--;
                //System.out.println(diff); 
              if(Math.abs(target -  curr_sum) < Math.abs(diff))
                  diff = target - curr_sum;
           }
          // System.out.println(diff); 
        }
        System.out.println(diff);
        return target - diff;
    }
}