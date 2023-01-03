class Solution {
    public int minimumPartition(String s, int k) {
        List <String> list = new ArrayList<>();
        int i=0,j=0;
        while(j < s.length()){
            if(i==j && Long.parseLong(s.substring(i,j+1)) > k){
                return -1;
            }
            if(Long.parseLong(s.substring(i,j+1)) <= k){
                j++;
            }
            else {
                list.add(s.substring(i,j));
                i = j;
            }
            
        }
        list.add(s.substring(i,j));        
       return list.size(); 
        
    }
}