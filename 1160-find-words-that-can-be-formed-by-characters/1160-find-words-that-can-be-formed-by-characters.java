class Solution {
    public int countCharacters(String[] words, String chars) {
        int[]freq = new int[26];
        for(int i=0;i<chars.length();i++){
            freq[chars.charAt(i)-'a']++;
        }
        int ans = 0;
        
        for(String word : words){
            int [] freqTemp = freq.clone();
            int count = 0;
            for(int i =0;i<word.length();i++){
                if(freqTemp[word.charAt(i) - 'a'] > 0){
                    count++;
                    freqTemp[word.charAt(i) - 'a']--;
                }
                if(count == word.length())
                    ans += word.length();
            }
        }
        
        return ans;
    }
}