class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int[] freq = new int[201];
        int max = Integer.MIN_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i = 0;i<nums.length;i++){
            freq[nums[i]]++;
            max = Math.max(max,freq[nums[i]]);
        }
        
        int i =1;
        while(i<=max){
            List<Integer>lst = new ArrayList<>();
            for(int j =0;j<201;j++){
                if(i<=freq[j]){
                    lst.add(j);
                }
            }
            if(lst.size() > 0){
                res.add(lst);
            }
            i++;
        }
        return res;
    }
}