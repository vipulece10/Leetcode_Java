class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st =new Stack<>();
        int x;
        int y;
        for(String token : tokens){
            if(token.equals("+")){
                
                x = Integer.parseInt(st.pop());
                y = Integer.parseInt(st.pop());
                st.add(String.valueOf(y + x));
            }
            else if(token.equals("-")){
               
                x = Integer.parseInt(st.pop());
                y = Integer.parseInt(st.pop());
                 st.add(String.valueOf(y - x));
            }
            else if(token.equals("*")){
                
                x = Integer.parseInt(st.pop());
                y = Integer.parseInt(st.pop());
                 st.add(String.valueOf(y * x));
            }
            else if(token.equals("/")){
                
                x = Integer.parseInt(st.pop());
                y = Integer.parseInt(st.pop());
                 st.add(String.valueOf(y / x));
            }
            else{
                st.add(token);
            }
            
        }
        
        
       return Integer.parseInt(st.pop()); 
       
    }
}