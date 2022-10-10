class Solution {
    public int minimumOperations(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        while(index < nums.length){
        if(nums[index] > 0){
        set.add(nums[index]);
        }
        index++;
        }
        
        return set.size();
    }
}