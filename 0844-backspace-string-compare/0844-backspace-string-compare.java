class Solution {
    public boolean backspaceCompare(String s, String t) {
        return resultantString(s).equals(resultantString(t));
    }
    private String resultantString(String str) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < str.length()){
            if(str.charAt(i) != '#'){
                st.add(str.charAt(i));
            }
            else{
                if(!st.isEmpty()){
                    st.pop();
                }
            }
           i++;     
        }
        StringBuilder sb = new StringBuilder();
        if (st.size() == 0)
            return "";
            
        while(!st.isEmpty()){
            sb.append(String.valueOf(st.pop()));
        }
        return sb.toString();
    }
}