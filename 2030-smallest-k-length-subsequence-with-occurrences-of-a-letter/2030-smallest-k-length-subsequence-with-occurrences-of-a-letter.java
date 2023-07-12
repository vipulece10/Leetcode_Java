class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        /*
        https://youtu.be/IUbWew2HH0s
        
        Input: s = "leet", k = 3, letter = "e", repetition = 1
        Output: "eet"
       i                i    i
       l    e   e   t   c   o   d   e
       0    1   2   3   4   5   6   7   =8 
        st [e,c,d]         repetition = 1   count =1
                    i   i
                    a a b b  4    repet = 2,k =3,letter b 
        st [a,a,]                  repetition  count =2
        */
        int n = s.length();
        int count = 0;
        for(int i = 0;i< n;i++){
            if(s.charAt(i) == letter)
                count++;
        }
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            while(!st.isEmpty() && ((st.peek() > s.charAt(i) && st.size()+n-i > k && (st.peek() !=letter || count > repetition)) || (k - st.size() < repetition))){
                if(st.peek() == letter){
                    repetition++;
                } 
                    st.pop();
            }
            if(st.size() < k){
                if(s.charAt(i) == letter){
                    repetition --;
                }
                st.add(s.charAt(i));
                
                
            }
            if(s.charAt(i) == letter)
                count--;
        }
        
        StringBuilder sb = new StringBuilder(st.size());
        for(Character c : st){
            sb.append(c);
        }
        
       return sb.toString();
    }
}