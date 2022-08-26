class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<List<Integer>> res=new ArrayList<>();
        
        //to iterate the nums array to find a of a+b+c=0
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low=i+1;
                int high=nums.length-1;
                int sum=0-nums[i];
              System.out.print("sum"+sum);  
                while(low<high){
                    if(nums[low] + nums[high]==sum){
                        List <Integer> list=new ArrayList<>();
                      //  list.add(nums[i],nums[low],nums[high]);
                        list.add(nums[i]);
                        list.add(nums[low]);
                        list.add(nums[high]);
                     
                        res.add(list);
                       
                        while(low<high && nums[low]==nums[low+1]){
                            low++;
                        }
                        while(low<high && nums[high]==nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high]<sum){
                        low++;
                    }
                    else{
                        high--;
                    }
                }
            }
        }
        return res;
    }
}