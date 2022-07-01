class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->(b[1]-a[1]));
        int units=0;
        for (int [] item:boxTypes){
            int box_count=0;
            if(truckSize>0){
                box_count=Math.min(truckSize,item[0]);
                units+=box_count*item[1];
                truckSize-=box_count;
            }
            
            if (truckSize == 0){
                return units;
            }
        }
        return units;
    }
}