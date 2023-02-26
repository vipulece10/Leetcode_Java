class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE;
        int high = 0;
        int res = Integer.MAX_VALUE;
        for(int weight : weights){
            high += weight;
            low = Math.max(low,weight);
        }
        
        System.out.println("low" + low + " high" + high);
        while(low < high){
            int mid = low + (high - low)/2;
            System.out.println(mid);
            if(canShip(mid,weights,days)){
                high = mid;
               // res = Math.min(res,mid);
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canShip(int mid,int[] weights,int days){
        int sum = 0;
        int count = 1;
        for(int i = 0;i < weights.length;i++){
            sum +=weights[i];
            if(sum > mid){
                sum = weights[i];
                count++;
            }
        }
        return count <= days; 
    }
}