class Solution {
    public String convert(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        if(numRows == 1){
            return s;
        }
        for(int i =0;i<numRows;i++){
            int j = i;
            while(j < s.length()){
                sb.append(s.charAt(j));
                 int increment = j + 2*(numRows - 1) - (2*i);
                if(i > 0 && i < numRows - 1 && increment < s.length()){
                 sb.append(s.charAt(increment));  
                }
                j = j + 2 *(numRows - 1);
            } 
            }
          return sb.toString();  
    }
}