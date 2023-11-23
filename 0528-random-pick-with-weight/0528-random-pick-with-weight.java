class Solution {
    private int [] prefixSums;
    private int totalSum; 

    public Solution(int[] w) {
        this.prefixSums = new int[w.length];
        prefixSums[0] = w[0];
        for(int i = 1;i<w.length;i++){
            prefixSums[i] = prefixSums[i-1] + w[i];
        }
        this.totalSum = prefixSums[w.length - 1];
    }
    
    public int pickIndex() {
        double target = this.totalSum * Math.random();
        int low = 0, high = this.prefixSums.length - 1;
        
        while(low < high){
            int mid = low + (high - low)/2;
            if(target > this.prefixSums[mid]){
                low = mid + 1;
            }else{
                high = mid;
            }
            
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */