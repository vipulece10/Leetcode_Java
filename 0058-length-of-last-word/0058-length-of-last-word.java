class Solution {
    public int lengthOfLastWord(String s) {
        String str = s.trim();
        String [] tokens = str.split(" ");
        int length = 0;
        for(String token : tokens){
            if (token.length() > 0){
                length = token.length();
            }
        }
        return length;
    }
}