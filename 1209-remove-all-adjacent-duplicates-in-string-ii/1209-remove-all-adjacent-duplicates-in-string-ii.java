class Solution {
    public String removeDuplicates(String s, int k) {
        /*
        s = "deeedbbcccbdaa", k = 3
        st ={d e }   e.    k=1
        
        */
        
        Stack<Pair<Character,Integer>> st = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            if(st.isEmpty() || st.peek().getKey() != s.charAt(i)){
                st.push(new Pair<>(s.charAt(i),1));
            }else{
                Pair<Character,Integer> top = st.pop();
                st.push(new Pair<>(top.getKey(),1+top.getValue()));
                
                if(st.peek().getValue() == k){
                    st.pop();
                }
            }
        }
        
        String ans = "";
        
        while(!st.isEmpty()){
            Pair<Character,Integer> first = st.pop();
            int val = first.getValue();
            while(val > 0){
                ans = first.getKey() + ans;
                val--;
            }
        }
        return ans;
    }
}