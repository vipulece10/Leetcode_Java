class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> star = new Stack<>();
        
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == '('){
                open.add(i);
            }   
            else if(s.charAt(i) == '*'){
                star.add(i);
            }
            else{
                if(!open.isEmpty()){
                    open.pop();
                }
                else if(!star.isEmpty()){
                    star.pop();
                }else{
                    return false;
                }
            }
        }
        
        while(!open.isEmpty()){
            if(star.isEmpty()){
                return false;
            }
            if(open.peek() < star.peek()) {
                open.pop();
                star.pop();
            }
            else{
                return false;
            }
        }
    return true;
    }
}