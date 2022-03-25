class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->((a[0]-a[1])-(b[0]-b[1])));
        int sum=0;
        int n=costs.length;
        for(int i=0;i<costs.length;i++){
            if(i < n/2)
                sum+=costs[i][0];
            else
                sum+=costs[i][1];
        }
        return sum;
    }
}