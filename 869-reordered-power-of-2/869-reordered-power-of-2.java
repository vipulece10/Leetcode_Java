class Solution {
    public boolean reorderedPowerOf2(int n) {  
        for(int i=0;i<31;i++){
            int [] PowerOf2DigitsFreq = new int[10];
            PowerOf2DigitsFreq = countDigits(1 << i );  
            if(Arrays.equals(countDigits(n),PowerOf2DigitsFreq))
                return true;
        }
        return false;
    }
    
    public int[] countDigits(int n){
        int [] digitsFreq = new int[10];
        while( n != 0){
            digitsFreq[ n % 10] ++;
            n=n/10;
        }
        return digitsFreq;
    }
}