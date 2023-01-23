class Solution {
    public int findJudge(int n, int[][] trust) {
        HashMap <Integer,Integer> hmap1 = new HashMap<>();
        HashMap <Integer,Integer> hmap2 = new HashMap<>();
        
        for(int i = 1;i<=n;i++){
            hmap1.put(i,0);
            hmap2.put(i,0);
        }
        
        for(int [] element : trust){
            hmap1.put(element[0],hmap1.getOrDefault(element[0],0)+1);
            hmap2.put(element[1],hmap2.getOrDefault(element[1],0)+1);
        }
        
        for(int key : hmap1.keySet()){
            int value = hmap1.get(key);
            if (value == 0 && hmap2.get(key) == n-1){
                return key;
            }
        }
        
        return -1;
        
    }
}