class Solution {
    public int largestAltitude(int[] gain) {
        int start = 0;
        int maxAltitude = 0;
        
        for(int i =0;i<gain.length;i++){
            start += gain[i];
            maxAltitude = Math.max(maxAltitude,start);
        }
        return maxAltitude;
    }
}