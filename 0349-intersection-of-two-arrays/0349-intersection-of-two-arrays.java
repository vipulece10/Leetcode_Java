class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums2.length > nums1.length)
            return   intersection(nums2,nums1);
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int num : nums1){
            set.add(num);
        }
        List<Integer> lst = new ArrayList<>();
        for(int i =0;i<nums2.length;i++){
            if(set.contains(nums2[i])){
                lst.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int [] res = new int[lst.size()];
        for(int i =0;i<lst.size();i++){
          res[i] = lst.get(i);  
        }
        return res;
        //return lst.toArray(new int[lst.size()]);
    }
}