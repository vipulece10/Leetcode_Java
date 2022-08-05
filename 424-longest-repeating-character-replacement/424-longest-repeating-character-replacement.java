class Solution {
    public int characterReplacement(String s, int k) {
        int [] freq = new int[26];
        int i=0;
        int j=0;
        int count = 0;
        int mostfrequent = Integer.MIN_VALUE;
        while(j < s.length()) {
            freq[s.charAt(j)-'A']++;
            mostfrequent = Math.max(mostfrequent,freq[s.charAt(j)-'A']);
            
            if((j-i+1) - mostfrequent > k){
               freq[s.charAt(i)-'A']--;
                i++;
            }
            
            count = Math.max(count,j-i+1);
            
            j++;
            
        }
        
        return count;
        
    }
}