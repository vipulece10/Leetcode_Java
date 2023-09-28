class Solution {
    public int[] avoidFlood(int[] rains) {
        /*
                 0 1 2 3 4 5
        rains = [1,2,0,0,2,1]
        
        map[1->0,2->1]        pq[2,3]
        
        */
        int [] ans = new int[rains.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        TreeSet<Integer> tset = new TreeSet<>();
        
        for(int i=0;i<rains.length;i++){
            if(rains[i] > 0){
                if(map.containsKey(rains[i])){
                    int val = map.get(rains[i]);
                    Integer data = tset.higher(val);
                    if(data == null){
                       return new int[]{}; 
                    }else{
                        ans[data] = rains[i];
                        tset.remove(data);
                        map.put(rains[i],i);
                        ans[i] = -1;
                    }
                        
                }else{
                    map.put(rains[i],i);
                        ans[i] = -1;
                }
            }else{
                tset.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}