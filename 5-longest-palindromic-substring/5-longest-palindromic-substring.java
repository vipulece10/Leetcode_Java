class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        boolean [][] dp = new boolean[s.length()][s.length()];
        if(s.length() == 0)
            return s;
        
        for(int i =0;i < s.length();i++){
            dp[i][i] = true;
            max=1;
            start =i;
        }
        
        for(int i = 0; i < s.length()-1;i++){
            if(s.charAt(i) == s.charAt(i+1)){
            dp[i][i+1] = true;
            max = 2;
            start = i;
        }
        }
        int n = s.length();
        for(int k = 3; k <= s.length();k++){
            for(int i = 0; i < n-k+1;i++){
                int j = i+k-1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
                    dp[i][j] = true;
                    max = k;
                    start = i;
                }
            }
           
        }
        
        return s.substring(start,start + max );
        
    }
}