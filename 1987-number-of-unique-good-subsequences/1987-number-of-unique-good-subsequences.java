class Solution {
    public int numberOfUniqueGoodSubsequences(String binary) {
        //https://www.codingninjas.com/studio/library/number-of-unique-good-subsequences
        int endsWithOne = 0;
        int endsWithZero = 0;
        boolean hasZero = false;
        int mod = 1000000007;
        for(int i = 0;i<binary.length();i++){
            if(binary.charAt(i) == '1'){
               endsWithOne =  (endsWithOne + endsWithZero + 1) % mod;
            }
            else{
                endsWithZero =  (endsWithOne + endsWithZero) % mod;
                hasZero = true;
            }
        }
        
        return hasZero ? (endsWithOne + endsWithZero + 1) % mod : (endsWithOne + endsWithZero) % mod;
        
    }
}