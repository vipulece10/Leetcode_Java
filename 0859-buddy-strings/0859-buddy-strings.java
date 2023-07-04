class Solution {
    public boolean buddyStrings(String s, String goal) {
        int [] freq = new int[26];
        if(s.length() != goal.length())
            return false;
        
        if(s.equals(goal))
        {
            for(int i =0;i<s.length();i++){
                freq[s.charAt(i) -'a']++;
                if(freq[s.charAt(i) -'a'] == 2)
                    return true;
            }
            return false;
        }
        
        int firstIndex = -1;
        int secondIndex = -1;
        
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) != goal.charAt(i)){
                if(firstIndex == -1){
                    firstIndex = i;
                }
                else if(secondIndex == -1){
                    secondIndex = i;
                }
                else{
                    return false;
                }
                    
            }
            
        }
        if(secondIndex == -1)
            return false;
        
        //ab
        //ba
        //fs
        
        return s.charAt(firstIndex) == goal.charAt(secondIndex) &&
              s.charAt(secondIndex) == goal.charAt(firstIndex);
        
    }
}