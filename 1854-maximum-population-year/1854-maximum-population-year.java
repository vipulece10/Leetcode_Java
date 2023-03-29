class Solution {
    public int maximumPopulation(int[][] logs) {
        int [] years = new int[101];
        int j = 0;
        int maxval = 0;
        int maxyear = 1950;
        while(j < logs.length){
            years[logs[j][0] - 1950]++;
            years[logs[j][1] - 1950]--;
            j++;
        }
        
        for(int i = 1; i<101; i++){
            years[i] = years[i] +years[i-1];
        }
        
        for(int i = 0; i<101; i++){
            if (years[i] > maxval){
                maxval = years[i];
                maxyear = 1950 + i;
            }
        }
        return maxyear;
    }
}