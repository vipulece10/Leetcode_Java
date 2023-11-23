class Solution {
    public int calculate(String s) {
        /*
        
        https://youtu.be/3AEKyHx3tzU
        (1+(4+5+2)-3)+(6+8)
        
        */
        int number = 0;
        int sign = 1;
        int result = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                number = number * 10 + s.charAt(i) - '0';
            }else if(s.charAt(i) == '+'){
                result += (number * sign);
                number = 0;
                sign = 1;
            }else if(s.charAt(i) == '-'){
                result += (number * sign);
                number = 0;
                sign = -1;
            }else if(s.charAt(i) == '('){
                st.add(result);
                st.add(sign);
                result =0;
                number  = 0;
                sign = 1;
            }else if(s.charAt(i) == ')'){
                result += (number * sign);
                number = 0;
                int lastSign = st.pop();
                int lastResult = st.pop();
                result = result * lastSign;
                result += lastResult;
            }
        }
        
        result += (number * sign);
        
        return result;
    }
}