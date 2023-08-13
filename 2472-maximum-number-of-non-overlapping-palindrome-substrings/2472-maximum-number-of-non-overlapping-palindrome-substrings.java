class Solution {
   //https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/discuss/2809048/Longest-Palindromic-Substring-oror-Easy-to-Understand-oror-Java-oror-Expanding-around-a-fixed-pivot 
    
    public int maxPalindromes(String s, int k) {
        int [] arr = new int [2];
        int lastIndex = 0;
        int count = 0;
        for(int i =0;i<s.length();i++){
            boolean isPossible = false;
            arr[0] = i;
            arr[1] = i;
            isPossible = getLen(arr,s,lastIndex,k);
            if(isPossible){
                lastIndex = arr[1] + 1;
                count++;
            }
            else{
                arr[0] = i;
                arr[1] = i + 1;
                isPossible = getLen(arr,s,lastIndex,k);
                if(isPossible){
                lastIndex = arr[1] + 1;
                count++;
                }
            }
        }
        return count;
    }
    
    public boolean getLen (int [] arr,String s,int lastIndex,int k){
        
        while(arr[0] >= lastIndex && arr[1] < s.length() && (s.charAt(arr[0]) == s.charAt(arr[1]))){
            if((arr[1] - arr[0] + 1) >= k)
                return true;
            
            arr[0]--;
            arr[1]++;
        }
        return false;
    }
    
}