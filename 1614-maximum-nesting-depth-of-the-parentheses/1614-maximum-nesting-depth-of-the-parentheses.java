class Solution {
    public int maxDepth(String s) {
        /*
        //"(1+(2*3)+((8)/4))+1"
        */
        
        int depth = 0;
        int maxdepth = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                depth++;
            }
            if(s.charAt(i) == ')'){
                depth--;
            }
            maxdepth = Math.max(maxdepth,depth);
        }
        return maxdepth;
    }
}