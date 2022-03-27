class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int count=0;
        PriorityQueue <int[]> pq=new PriorityQueue<>((a,b)-> (a[0] != b[0] ? b[0]-a[0] : b[1]-a[1]));
        int [] res=new int[k];
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1){
                    count++;
                }
                
            }
            pq.add(new int[]{count,i});
            count=0;
        }
        while(pq.size()>k){
            pq.poll();
        }
        
        for(int j=k-1;j>=0;j--){
            res[j]=pq.poll()[1];
        }
        return res;
    }
}