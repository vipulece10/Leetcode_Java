class Solution {
    public int equalPairs(int[][] grid) {
        int n =grid.length;
        Map<String,Integer> hm = new HashMap<>();
        for(int[] row :grid ){
            String rowString = Arrays.toString(row);
            hm.put(rowString,hm.getOrDefault(rowString,0) + 1);
        }
        
        int count = 0;
        
        for(int c= 0;c<n;c++){
             int[] colArray = new int [n];
             for(int r=0;r<n;r++){
                 colArray[r] = grid[r][c];
             }
            String colString  = Arrays.toString(colArray);
            count += hm.getOrDefault(colString,0);
        }
        return count;
    }
}