class Solution {
    public int maximumSum(int[] arr) {
        //https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/discuss/377522/C%2B%2B-forward-and-backward-solution-with-explanation-and-picture
        /*
        arr = [1,-2,0,3]
        fw = [1,0,0,3]
        bw = [2,1,3,3]
        0 to n-3
        max=Math.max(max,fw[i],fw[i]+bw[i+2])
        */
        if(arr.length == 1)
            return arr[0];
        
        //calculate forward max sum
        int currForwardMaxSum = 0;
        int totalSum = Integer.MIN_VALUE;
        int [] forwardSum = new int[arr.length];
        int [] backwardSum = new int[arr.length];
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0;i<arr.length;i++){
            currForwardMaxSum += arr[i];
            totalSum = currForwardMaxSum;
            if(currForwardMaxSum < 0){
                currForwardMaxSum = 0;
            }
            
            forwardSum[i] = totalSum;
        }
        
        ////calculate backward max sum
        int currBackwardMaxSum = 0;
        int totalBackwardSum = Integer.MIN_VALUE;
        for(int i = arr.length-1;i>=0;i--){
            currBackwardMaxSum += arr[i];
            totalBackwardSum = currBackwardMaxSum;
            if(currBackwardMaxSum < 0){
                currBackwardMaxSum = 0;
            }
            
            backwardSum[i] = totalBackwardSum;
        }
        
        for(int i = 0;i<arr.length-2;i++){
           maxSum = Math.max(maxSum,Math.max(forwardSum[i],forwardSum[i] + backwardSum[i+2])); 
        }
        int index = arr.length - 2;
        while(index < arr.length){
             maxSum = Math.max(maxSum,forwardSum[index]);
            index++;
        }
        return maxSum;
        
    }
}