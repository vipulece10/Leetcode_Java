class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(distinctIntegersFirstArrayOnly(nums1,nums2));
        ans.add(distinctIntegersFirstArrayOnly(nums2,nums1));
        return ans;
    }
    private List<Integer> distinctIntegersFirstArrayOnly(int[] arr1,int[] arr2){
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2  = new HashSet<>();
       // List<Integer> res = new ArrayList<>();
        
        for(int num : arr2){
            set2.add(num);
        }
        
        for(int element : arr1){
            if(!set2.contains(element)){
                set1.add(element);
            }
        }
        
        return new ArrayList<>(set1);
    }
}