class Solution {
    public String capitalizeTitle(String title) {
        String [] tokens =title.split(" ");
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i < tokens.length){
            String word = tokens[i];
            if(word.length()<=2){
                for(int j=0;j<word.length();j++){
                    sb.append(Character.toLowerCase(word.charAt(j)));
                }
            }
            else{
            sb.append(Character.toUpperCase(word.charAt(0)));
            for(int j =1;j<word.length();j++){
                sb.append(Character.toLowerCase(word.charAt(j)));
            }
            }
            sb.append(" ");
            i++;
        }
        return sb.toString().trim();
    }
}