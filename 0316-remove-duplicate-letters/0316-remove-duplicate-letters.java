class Solution {
    public String removeDuplicateLetters(String s) {
        
        /*
        s = "cbacdcbc"
        stack = [c] | [b] | a | c| d |
        freq={a->0,c->4-1-1,b->2-1,d->0}
        visited = a,c,d
        */
        Stack<Character> st = new Stack<>();
        int [] freq =new int[26];
        Set<Character> vis = new HashSet<>();
        
        for(int i =0;i<s.length();i++){
            freq[s.charAt(i) - 'a']++; 
        }
        
        for(int i=0;i<s.length();i++){
            if(vis.contains(s.charAt(i))){
                freq[s.charAt(i) - 'a']--;
                continue;
            }
            while(!st.isEmpty() && s.charAt(i) < st.peek() && freq[st.peek() - 'a'] > 0){
              vis.remove(st.peek());
              st.pop();
            }
            st.push(s.charAt(i));
            vis.add(s.charAt(i));
            freq[s.charAt(i) - 'a']--;
            }
        StringBuilder sb = new StringBuilder();
        
        while(!st.isEmpty()){
            sb.append(String.valueOf(st.pop()));
        }
        String ans = sb.reverse().toString();
        return ans;
    }
}