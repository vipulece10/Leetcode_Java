class Solution {
    public int alternateDigitSum(int n) {
        String str = String.valueOf(n);
        int len = str.length();
        int sum = 0;
        while(n > 0){
            int mod = n % 10;
            mod = len%2 == 0 ? -1 *mod : mod;
            sum += mod;
            n=n/10;
            len--;
        }
        
        return sum;
    }
}