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
        
        // if(i==j && Integer.parseInt(s.substring(i,j+1)) > k){
        //         return -1;
        //     }
        list.add(s.substring(i,j));
        
//         Iterator itr = set.iterator();
        
//         while(itr.hasNext()){
//             System.out.println(itr.next());
       //  }
        
        //System.out.println(set);
        
       return list.size(); 
        
    }
}