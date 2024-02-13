class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       ArrayList <List<Integer>> ans=new ArrayList<>();
       ArrayList <Integer> subset=new ArrayList<>();
       dfs(0,nums,subset,ans);
       return ans;
    }
    
    public void dfs(int index,int[] nums,List<Integer> subset,List<List<Integer>> ans){
        if(index==nums.length){
            //Added a temp arraylist to clone subset
            //passing a reference of subset to ans will not work 
            // as we are removing elements of subset while recursion.
            ArrayList <Integer> temp=new ArrayList<>();
            temp.addAll(subset);
           // ans.add(subset);
            ans.add(temp);
            return;
        }
        subset.add(nums[index]);
        dfs(index+1,nums,subset,ans);
        
        subset.remove(subset.size()-1);
        dfs(index+1,nums,subset,ans);
        
    }
}