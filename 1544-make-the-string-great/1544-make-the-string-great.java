class Solution {
    public String makeGood(String s) {
        /*
        leEeetcode
        */
        Stack<Character> st = new Stack<>();
        for(int i = 0;i < s.length();i++){
        if(st.isEmpty()){
            st.add(s.charAt(i));
        }
            else{
               if(Math.abs(s.charAt(i) - st.peek()) == 32){
                   // while(!st.isEmpty() && Math.abs(s.charAt(i) - st.peek()) == 32){
                    st.pop();
                //}    
             }
                else{
                      st.add(s.charAt(i));  
                    } 
            }
          //  System.out.println(st.toString());
        }
       // System.out.println(st.toString());
        StringBuilder sb = new StringBuilder();
        
        // System.out.println("size " + st.size());
        
       while(!st.isEmpty()){
           sb.append(st.pop());
       }
            System.out.println(sb.toString() + st.size());
        
        return sb.reverse().toString();
}
}