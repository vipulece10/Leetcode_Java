class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for(int i=left;i<=right;i++){
            int word_length = words[i].length();
            char start = words[i].charAt(0);
            char end = words[i].charAt(word_length - 1);
            
            if((start =='a' || start == 'e' || start == 'i' || start == 'o' || start == 'u') &&
              (end == 'a' || end == 'e' || end == 'i' || end == 'o' || end == 'u')){
                count++;
            }
        }
        return count;
    }
}