class Solution {
    public int longestValidParentheses(String s) {
        //https://www.youtube.com/watch?v=tzbEtUM78RU
        //  s = ")()())"
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int res = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.add(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.add(i);
                }
                res = Math.max(res,i - st.peek());
            }
        }
        return res;
    }
}