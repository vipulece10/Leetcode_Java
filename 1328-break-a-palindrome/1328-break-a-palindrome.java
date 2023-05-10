class Solution {
    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if(palindrome.length() == 1)
            return "";
        char[] palindrome_arr = palindrome.toCharArray();
        for(int i = 0;i<palindrome_arr.length/2;i++){
            if(palindrome_arr[i] != 'a'){
                palindrome_arr[i] = 'a';
                return String.valueOf(palindrome_arr);
            }
        }
        
        palindrome_arr[length - 1] = 'b';
        return String.valueOf(palindrome_arr);
    }
}