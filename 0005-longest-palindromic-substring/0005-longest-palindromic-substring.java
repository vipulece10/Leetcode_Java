class Solution {
    public String longestPalindrome(String s) {
        // Approach 1
//         int max = 0;
//         int start = 0;
//         boolean [][] dp = new boolean[s.length()][s.length()];
//         if(s.length() == 0)
//             return s;
        
//         for(int i =0;i < s.length();i++){
//             dp[i][i] = true;
//             max=1;
//             start =i;
//         }
        
//         for(int i = 0; i < s.length()-1;i++){
//             if(s.charAt(i) == s.charAt(i+1)){
//             dp[i][i+1] = true;
//             max = 2;
//             start = i;
//         }
//         }
//         int n = s.length();
//         for(int k = 3; k <= s.length();k++){
//             for(int i = 0; i < n-k+1;i++){
//                 int j = i+k-1;
//                 if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true){
//                     dp[i][j] = true;
//                     max = k;
//                     start = i;
//                 }
//             }
           
//         }
        
//         return s.substring(start,start + max );
        
        // Approach 2
        /*
        s = "babad"
        bab
        left = -1;
        right = 3
        
        //odd
        expandCenter(left,right){
        while(0<=left && right < str.length && str[left] == str[right])
        left--;
        right++;
        }
        return right - left -1;
        //even 
        */
       // int maxCount = Integer.MIN_VALUE;
        int maxLen = 0;
        String res ="";
        for(int i = 0;i< s.length();i++){
            int oddPalindrome = expandFromCenter(i,i,s);
            int evenPalindrome = expandFromCenter(i,i+1,s);
            int len =Math.max(evenPalindrome,oddPalindrome);
            if(len > maxLen){
                maxLen = len;
                int left = i -((len-1)/2);
                int right = i+(len/2);
                res = s.substring(left,right+1);
            }
        }
        return res;
    }
    
    public int expandFromCenter(int left,int right,String s){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left -1;
    }
}