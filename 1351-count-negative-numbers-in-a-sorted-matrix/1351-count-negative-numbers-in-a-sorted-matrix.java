class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid[0].length;
        for(int[] row : grid){
            int index = findFirstNegative(row);
            count += n - index;
        }
        return count;
    }
    
    int findFirstNegative(int[] row){
        int low = 0;
        int high = row.length - 1;
        while(low <= high){
            int mid = low+(high - low)/2;
            if(row[mid] < 0){
                high = mid - 1;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
}