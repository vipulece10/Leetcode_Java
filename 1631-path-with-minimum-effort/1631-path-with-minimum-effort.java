class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        if(rows == 1 && cols == 1)
            return 0;
        int[][] efforts = new int[rows][cols];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[2]);
        pq.add(new int[]{0,0,0});
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int[] effort : efforts){
            Arrays.fill(effort,Integer.MAX_VALUE);
        }
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int curr_row = curr[0];
            int curr_col = curr[1];
            int diff = curr[2];
            for(int [] dir : dirs){
                int next_row = curr_row + dir[0];
                int next_col = curr_col + dir[1];
                if(next_row < 0 || next_row >= rows || next_col < 0 || next_col >= cols){
                    continue;
                }
                int next_diff = Math.max(diff,Math.abs(heights[curr_row][curr_col] - heights[next_row][next_col]));
                if(next_diff < efforts[next_row][next_col]){
                    pq.add(new int[]{next_row,next_col,next_diff});
                    efforts[next_row][next_col] = next_diff;
                }
            }
        }
        
        return efforts[rows - 1][cols - 1];
    }
}