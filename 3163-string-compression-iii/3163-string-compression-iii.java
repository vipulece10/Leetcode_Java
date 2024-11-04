class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int n = word.length();
        for(int i = 0;i<word.length();i++){
            int count =1;
            while(i < n-1 && word.charAt(i) == word.charAt(i+1)){
                count++;
                i++;
                if(count == 9){
                   // sb.append(String.valueOf(count) + word.charAt(i));
                    break;
                }
            }
            sb.append(String.valueOf(count) + word.charAt(i));
            
        }
        return sb.toString();
    }
}