class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        /*
        answerKey = "TTFF", k = 2
        
                    j
        "T  T   F   F"       k     countTrue = 4 countFalse = 2
         i
          
          
          moreFreq = Math.max(countTrue,countFalse) 2
          
          length - moreFreq > k
            move Window
                            j
        "T  T   F   T   T   F   T   T"
         i
        */
        
        int i =0,j =0;
        int countTrue = 0,countFalse = 0;
        int moreFreq =Integer.MIN_VALUE; 
        int maxCount =Integer.MIN_VALUE; 
        while(j < answerKey.length()){
            if(answerKey.charAt(j) == 'T'){
                countTrue++;
            }else{
                countFalse++;
            }
            moreFreq = Math.max(countTrue,countFalse);
            
            if((j-i+1) -moreFreq > k){
                if(answerKey.charAt(i) == 'T'){
                countTrue--;
                }else{
                    countFalse--;
                }
                i++;
            }
            maxCount = Math.max(maxCount,j-i+1);
            j++;
        }
        return maxCount;
    }
}