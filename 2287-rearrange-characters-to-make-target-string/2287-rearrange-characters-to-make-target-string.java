class Solution {
    public int rearrangeCharacters(String s, String target) {
        int [] freqArray =new int [26];
        
        int count = 0;
        
        for(char c : s.toCharArray()){
            freqArray[c-'a']++;
        }
        int i=0;
        char [] targetarr = target.toCharArray();
        while(true){
            
            if(i == targetarr.length){
                count++;
                i=0;
            }
            
            if(freqArray[targetarr[i]-'a'] > 0)
            freqArray[targetarr[i]-'a']--;
            else
            break;
            
            i++;
            
        }
        
        return count;
    }
}