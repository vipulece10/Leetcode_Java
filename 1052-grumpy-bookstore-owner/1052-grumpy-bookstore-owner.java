class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        /*
        customers = [1,0,1,2,1,1,7,5], 
        grumpy =    [0,1,0,1,0,1,0,1]
        
        customers = [1,0,1,2,1,1,7,5], sum = 1+1+1+7
        grumpy =    [0,1,0,1,0,1,0,1]
        
        customers = [0,0,0,2,0,1,0,5], sum = 1+1+1+7
        */
        int n = customers.length;
        int sum = 0;
        int maxCount = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            if(grumpy[i] == 0){
                sum += customers[i];
                customers[i] = 0;
            }
        }
        int i = 0,j = 0;
        int count = 0;
        while(j < n){
            count += customers[j];
            if(j-i+1 == minutes){
                maxCount = Math.max(count,maxCount);
                count -= customers[i];
                i++;
            }
           j++;     
        }
        
        return sum + maxCount;
    }
}