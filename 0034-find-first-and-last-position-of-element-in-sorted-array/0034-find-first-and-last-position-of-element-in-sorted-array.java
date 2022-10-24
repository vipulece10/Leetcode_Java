class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []res = new int[2];
        res[0]= findFirstandLast(nums,target,true);
        System.out.println(res[0]);
        res[1] = findFirstandLast(nums,target,false);
        return res;
    }
    
    public int findFirstandLast (int [] nums,int target,boolean flag){
        int position_index = -1;
        int start = 0;
        int end = nums.length-1;
        
        while(start <= end){
            int mid = (start + end) / 2;
            System.out.println("mid " + mid);
            System.out.println("start " + start);
            System.out.println("end " + end);
            if(nums[mid] > target){
                end = mid-1;
            }
            else if(nums[mid] < target){
                start = mid + 1;
            }
            else if (target == nums[mid]){
                 position_index = mid;
                if (flag == true){
                   
                    end = mid - 1;
                }
                else{
                     
                    start = mid + 1;
                }
                
            }
        }
        
        return position_index;
    }
}