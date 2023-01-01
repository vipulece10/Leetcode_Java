class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> mapPatternS = new HashMap<>();
        HashMap<String,Character> mapSPattern = new HashMap<>();
        String [] tokens = s.split(" ");
        if(pattern.length() != tokens.length){
            return false;
        }
        
        for(int i=0;i<pattern.length();i++){
            char c = pattern.charAt(i);
            String w = tokens[i];
            
            if(mapPatternS.containsKey(c) && !mapPatternS.get(c).equals(w)){
                return false;
            }
            
            if(mapSPattern.containsKey(w) && !mapSPattern.get(w).equals(c))
            {
                return false;
            }
            
            mapPatternS.put(c,w);
            mapSPattern.put(w,c);
        }
        return true;
    }
}