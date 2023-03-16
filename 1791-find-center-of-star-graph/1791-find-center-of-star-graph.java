class Solution {
    public int findCenter(int[][] edges) {
        int [] nodes = new int [edges.length + 2]; 
        for(int [] edge : edges){
            nodes[edge[0]] += 1;
            nodes[edge[1]] += 1;
        }
        int res = 0;
        for(int i = 1;i<nodes.length;i++){
            if(nodes[i] > nodes[i-1]){
                res =i;
            }
        }
        return res;
    }
}