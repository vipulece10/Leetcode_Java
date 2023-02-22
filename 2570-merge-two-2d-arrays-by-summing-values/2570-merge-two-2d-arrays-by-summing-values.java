class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
       
        List<List<Integer>> lst = new ArrayList<>(); 
        int i =0,j = 0;
        while(i < n1  && j < n2){
            if(nums1[i][0] < nums2[j][0]){
                // nums3[k][0] = nums1[i][0];
                // nums3[k][1] = nums1[i][1];
                // k++;
                lst.add(Arrays.asList(new Integer []{nums1[i][0],nums1[i][1]}));
                i++;
            }
            else if(nums1[i][0] > nums2[j][0]){
                // nums3[k][0] = nums2[j][0];
                // nums3[k][1] = nums2[j][1];
                // k++;
                lst.add(Arrays.asList(new Integer []{nums2[j][0],nums2[j][1]}));
                j++;
            }
            else{
                // nums3[k][0] = nums2[i][0];
                // nums3[k][1] = nums1[i][1] + nums2[j][1]  ;
                lst.add(Arrays.asList(new Integer []{nums1[i][0],nums1[i][1] + nums2[j][1]}));
                i++;
               // k++;
                j++;
            }
        }
        
        while(i < n1){
            // nums3[k][0] = nums1[i][0];
            //     nums3[k][1] = nums1[i][1];
            //     k++;
            lst.add(Arrays.asList(new Integer []{nums1[i][0],nums1[i][1]}));
                i++;
        }
        
        while(j < n2){
            // nums3[k][0] = nums2[j][0];
            //     nums3[k][1] = nums2[j][1];
            //     k++;
            lst.add(Arrays.asList(new Integer []{nums2[j][0],nums2[j][1]}));
                j++;
        }
        
         int [][] nums3 = new int [lst.size()][2];
        for(int k =0;k<lst.size();k++){
            nums3[k][0] = lst.get(k).get(0);
            nums3[k][1] = lst.get(k).get(1);
        }
        
        return nums3;
        //return null;
        
    }
}