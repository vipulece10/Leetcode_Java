class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        System.out.println(max + " " + min);
        int result = 0;
        for(int i = 1;i < arrays.size();i++){
            result = Math.max(result,Math.abs(max - arrays.get(i).get(0)));
             
            result = Math.max(result,Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - min));
         
            max = Math.max(max,arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min,arrays.get(i).get(0));
            
        }
        
        return result;
        
    }
}