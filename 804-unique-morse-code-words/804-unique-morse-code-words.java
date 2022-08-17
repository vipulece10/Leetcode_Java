class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        
        HashSet <String> hs = new HashSet<>();
        String [] symbols = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        //StringBuilder sb = new StringBuilder();
        for(String word : words){
            int i =0;
            StringBuilder sb = new StringBuilder();
            while(i< word.length()){
                sb.append(symbols[word.charAt(i) - 'a']);
                i++;
            }
            hs.add(sb.toString());
        }
        
        return hs.size();
        
    }
}