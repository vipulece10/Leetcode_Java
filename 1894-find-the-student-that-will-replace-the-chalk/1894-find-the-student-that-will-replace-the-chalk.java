class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        /*
        [3,2,5],k = 7
         3,5,10
         sum = 10
         7 % 10
        */
        long sum =0;
        for(int i = 0;i<chalk.length;i++){
            sum +=chalk[i];
            if(sum > k){
               return i;
            }
        }
        
        int rem = k % (int)sum;
        
        for(int i = 0;i<chalk.length;i++){
            if(rem < chalk[i]){
                return i;
            }
            rem -= chalk[i]; 
        }
        return 0;
    }
}