class Solution {
    public int minSwaps(String s) {
        int countOnes = 0;
        int countZeros= 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '0')
                countZeros++;
            else
                countOnes++;
        }
        
        if (Math.abs(countOnes - countZeros) > 1)
            return -1;
        
        if(countZeros > countOnes){
            return Swaps_count(s,0);
        }
        
        if(countOnes > countZeros){
            return Swaps_count(s,1);
        }
        
        return Math.min(Swaps_count(s,0),Swaps_count(s,1));  
    }
    
    public int Swaps_count(String s, int num){
        int count = 0;
        for(int i =0;i<s.length();i++){
            if(num == 1){
                if(i%2 == 0){
                    if(s.charAt(i)-'0' != 1){
                        count++;
                    }
                }else{
                    if(s.charAt(i)-'0' != 0){
                        count++;
                    }
                }
            }
            if(num == 0){
                if(i%2 == 0){
                    if(s.charAt(i)-'0' != 0){
                        count++;
                    }
                }else{
                    if(s.charAt(i)-'0' != 1){
                        count++;
                    }
                }
            }
        }
        return count/2;
    }
}

