class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] indegree = new int[n];
        List<Integer> res = new ArrayList<>();
        for(List<Integer> lst : edges){
            indegree[lst.get(1)]++;
        }
        
        for(int i =0;i<indegree.length;i++){
            if(indegree[i] == 0){
                res.add(i);
            }
        }
        return res;
    }
}