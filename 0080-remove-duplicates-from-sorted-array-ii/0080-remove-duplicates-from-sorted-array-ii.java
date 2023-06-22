class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int n = nums.length;
        for(int i =0;i < n;i++){
            int startIndex = i;
            int count = 1;
            while(i < n-1 && nums[i] == nums[i + 1] ){
                count++;
                i++;
            }
            int len =Math.min(count,2);
            
            while(len > 0){
                nums[index] = nums[startIndex];
                index++;
                len --;
            }
        }
        return index;
    }
}