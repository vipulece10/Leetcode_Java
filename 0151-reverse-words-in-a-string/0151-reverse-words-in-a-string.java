class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        String [] tokens=s.split(" ");
        StringBuilder res=new StringBuilder();
        for(int i=tokens.length-1;i>=0;i--){
           // tokens[i]=tokens[i].trim();
          //  System.out.print("tokens "+i+" "+tokens[i]);
            if( !(tokens[i].equals(""))){
                // System.out.print("tokens "+i+" "+tokens[i]);
            res.append(tokens[i]);
            if(i!=0 ) {
                res.append(" ");
            }
        }
            
        }
        return res.toString();
        
    }
}