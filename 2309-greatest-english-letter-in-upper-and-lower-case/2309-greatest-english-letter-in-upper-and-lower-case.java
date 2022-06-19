class Solution {
    public String greatestLetter(String s) {
        char [] freq = new char[26];
        for(int i =0;i<s.length();i++){
            if(Character.isUpperCase(s.charAt(i)) && freq[s.charAt(i)-'A'] == 0){
                freq[s.charAt(i)-'A']++;
            }
            
        }
        
        
         for(int i =0;i<s.length();i++){
            
            if(Character.isLowerCase(s.charAt(i))  && freq[s.charAt(i)-'a'] == 1){
                freq[s.charAt(i)-'a']++;
            }
        }
        
        
        for(int i =25;i>=0;i--){
           
                if(freq[i]==2){
                    return Character.toString((char)('A'+i));
                }
                
            }
            
           
        
        return "";
        
    }
}