class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int [] freq = new int[26];
        for(char element : ransomNote.toCharArray()){
            freq[element-'a']++;
        }
        
        
        for(char element : magazine.toCharArray()){
            freq[element-'a']--;
        }
        
        for(char element : ransomNote.toCharArray()){
           
            if(freq[element-'a'] > 0)
                return false;
        }
               
        return true;
    }
}