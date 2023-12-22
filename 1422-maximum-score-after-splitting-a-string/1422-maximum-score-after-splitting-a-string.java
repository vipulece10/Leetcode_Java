class Solution {
    public int maxScore(String s) {
        /*
        s = "011101"
        Zeros = 2
        Ones = 4
        */
        int Ones = 0;
        int Zeros = 0;
        int ans = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '1'){
                Ones++;
            }
        }
        
        for(int i = 0;i<s.length()-1;i++){
            if(s.charAt(i) == '1'){
                Ones--;
            }else{
                Zeros++;
            }
            ans = Math.max(ans,Ones + Zeros);
        }
        return ans;
    }
}