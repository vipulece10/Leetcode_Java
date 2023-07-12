class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAverage = -99999;
        double sum = 0;
        
        int i =0,j =0;
        while(j < nums.length){
            sum += nums[j];
            if(j-i+1 == k){
                System.out.println(sum / k);
                maxAverage = Math.max(maxAverage,sum / k);
                //System.out.println(maxAverage);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return maxAverage;
    }
}