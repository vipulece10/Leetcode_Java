class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<num.length();i++){
            while(!st.isEmpty() && num.charAt(i) < st.peek() && k > 0){
                st.pop();
                k--;
            }
            st.add(num.charAt(i));
        }
        
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        if(st.size() == 0)
            return "0";
        StringBuilder res = new StringBuilder();
        
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        
        String ans = res.reverse().toString();
        System.out.println(ans);
        int i = 0;
        while(i < ans.length() && ans.charAt(i) == '0'){
            i++;
        }
            
         ans = ans.substring(i,ans.length());
        return ans.length() == 0 ? "0" : ans;
    }
}