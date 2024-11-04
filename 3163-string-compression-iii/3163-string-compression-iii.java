class Solution {
//     public String compressedString(String word) {
//         StringBuilder sb = new StringBuilder();
//         int n = word.length();
//         for(int i = 0;i<word.length();i++){
//             int count =1;
//             while(i < n-1 && word.charAt(i) == word.charAt(i+1)){
//                 count++;
//                 i++;
//                 if(count == 9){
//                    // sb.append(String.valueOf(count) + word.charAt(i));
//                     break;
//                 }
//             }
//             sb.append(String.valueOf(count) + word.charAt(i));
            
//         }
//         return sb.toString();
//     }
    
    public String compressedString(String word){
        /*
        "aaaaaaaaaaaaaabb"
        
        */
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        
        for(int i = 0;i<word.length() - 1; i++){
            if(word.charAt(i) == word.charAt(i+1)){
                if(count == 9){
                sb.append(count);
                sb.append(word.charAt(i));
                count = 1;
                   count = 1; 
                }else{
                   count++; 
                }
            }else{
                sb.append(count);
                sb.append(word.charAt(i));
                count = 1;
            }
        }
        
        sb.append(count);
        sb.append(word.charAt(word.length() - 1));
        return sb.toString();
    }
}