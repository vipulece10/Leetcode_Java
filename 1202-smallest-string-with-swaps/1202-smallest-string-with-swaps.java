class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int [] parent = new int [s.length()];
        int [] rank = new int[s.length()];
        HashMap<Integer,PriorityQueue<Character>> hm = new HashMap<>();
        StringBuilder res = new StringBuilder();
        
        for(int i =0;i<s.length();i++){
            parent[i] = i;
            rank[i] = 1;
        }
        
        for(List<Integer> pair : pairs){
            union(pair.get(0),pair.get(1),parent,rank);
        }
        int n= s.length();
        for(int i=0;i<n;i++){
            int p = find(i,parent);
            if(!hm.containsKey(p)){
                hm.put(p,new PriorityQueue<>());
            }
            hm.get(p).add(s.charAt(i));
        }
        
        for(int i = 0;i<n;i++){
            System.out.println("parent of "+ i +" "+ parent[i]);
        }
        
        for(int i=0;i<n;i++){
            int key = find(i,parent);
            res.append(String.valueOf(hm.get(key).poll()));
        }
        
        return res.toString();
    }
    
    private void union(int i,int j,int[] parent,int[] rank){
        int pi = find(i,parent);
       int pj = find(j,parent);
        if(pi == pj)
            return;
            
        if(rank[pi] >= rank[pj]){
            parent[pj] = pi;
            rank[pi] += rank[pj];
        }
        else{
            parent[pi] = pj;
            rank[pj] += rank[pi];
        }
        
    }
    
     private int find(int i,int [] parent){
        while(parent[i] != i){
            i = parent[i];
        }
        return i; 
    }
}