class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList <List<Integer>> ans=new ArrayList<>();
        ArrayList <Integer> subset=new ArrayList<>();
        Arrays.sort(nums);
       // ans.add(new ArrayList<>());
        dfs(0,subset,nums,ans);
        return ans;
    }
    
    public void dfs(int index,List<Integer> subset,int[]nums,List<List<Integer>> ans){
        ans.add(new ArrayList<>(subset));
      //  if(index==nums.length){
       //     System.out.print("size"+subset.size());
          //   ans.add(new ArrayList<>(subset));
     //       return;
     //   }
        
        for(int i=index;i<nums.length;i++){
            if((i>index) && nums[i-1]==nums[i]){
                continue;
            }
            subset.add(nums[i]);
            dfs(i+1,subset,nums,ans);
            subset.remove(subset.size()-1);
            
        }
    }
}