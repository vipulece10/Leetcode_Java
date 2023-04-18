class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int i = 0;
        int j = 0;
        String merged = "";
        while(i< n1 && j < n2){
            merged += String.valueOf(word1.charAt(i));
            merged += String.valueOf(word2.charAt(j));
            i++;
            j++;
        }
        
        while(i < n1){
            merged += String.valueOf(word1.charAt(i));
            i++;
        }
        
        while(j < n2){
            merged += String.valueOf(word2.charAt(j));
            j++;
        }
        return merged;
    }
}