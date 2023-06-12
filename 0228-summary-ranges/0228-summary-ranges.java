class Solution {
    public List<String> summaryRanges(int[] nums) {
        int startIndex = 0;
        int endIndex = 0;
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;
        if(nums.length == 1){
            res.add(String.valueOf(nums[0]));
            return res;
        } 
        for(int i =1;i<nums.length;i++){
            if(nums[i] == nums[i-1] + 1){
                endIndex = i;
            }else{
                if(startIndex == endIndex || endIndex < startIndex)
                    res.add(String.valueOf(nums[startIndex]));
                else{
                    String val = String.valueOf(nums[startIndex]) + "->" + String.valueOf(nums[endIndex]);
                    res.add(val);
                }
                startIndex = i;
            }
        }
        
        if(startIndex > endIndex)
            res.add(String.valueOf(nums[startIndex]));
        else{
                    String val = String.valueOf(nums[startIndex]) + "->" + String.valueOf(nums[endIndex]);
                    res.add(val);
                }
        return res;
    }
}