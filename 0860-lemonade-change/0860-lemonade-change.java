class Solution {
    public boolean lemonadeChange(int[] bills) {
        /*
        [5,5,5,10,20]
        take = 15 +10 -(10 - 5) +20 -(20 -5) = 
        give = 
        */
        int fiveCount = 0;
        int tenCount = 0;
        int twentyCount = 0;
        
        for(int i = 0; i<bills.length; i++){
            if(bills[i] == 5){
                fiveCount++;
            }
            else if (bills[i] == 10){
                if(fiveCount > 0){
                    fiveCount--;
                    tenCount++;
                }else{
                    return false;
                }
            }
            else{
                if(fiveCount > 0 && tenCount > 0){
                    fiveCount--;
                    tenCount--;
                    twentyCount++;
                }
                else if(fiveCount >= 3){
                    fiveCount -= 3;
                    twentyCount++;
                }
                else{
                    return false;
                }
            }
        }
    return true;
    }
}