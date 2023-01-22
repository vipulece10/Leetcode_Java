class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        //Arrays.sort(nums);
        helper(0,nums,ans,curr);
        return new ArrayList<>(ans);
    }
    
    public void helper(int index,int[]nums,Set<List<Integer>> ans,
                      List<Integer> curr){
        
        if(curr.size() >= 2){
            ans.add(new ArrayList<>(curr));
        }
        
        for(int i = index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i-1]) continue;
            if(curr.size() == 0 || nums[i] >= curr.get(curr.size()-1)){
                curr.add(nums[i]);
                helper(i+1,nums,ans,curr);
                curr.remove(curr.size() - 1);
            }
        }
        
    }
}