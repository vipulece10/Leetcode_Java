class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backtracking(0,nums,ans,res);
        return res;
    }
    
    private void  backtracking(int index,int[] nums,List<Integer>ans,List<List<Integer>>res){
        if(ans.size() == nums.length){
            res.add(new ArrayList<>(ans));
            return;
        }
        
        for(int i =0;i < nums.length;i++){
            if(ans.contains(nums[i]))
                continue;
            ans.add(nums[i]);
             backtracking(i+1,nums,ans,res);
            ans.remove(ans.size() - 1);
        }
        
    }
}