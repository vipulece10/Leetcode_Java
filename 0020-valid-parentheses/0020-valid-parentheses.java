class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack=new Stack <Character>();
        char popped=' ';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(' ){
                stack.push(')');
            }
            else if(s.charAt(i)=='{' ){
                stack.push('}');
            }
            else if(s.charAt(i)=='[' ){
                stack.push(']');
            }
            else if(s.charAt(i)==')' || s.charAt(i)=='}' || s.charAt(i)==']'){
                if(!stack.isEmpty()){
               popped=stack.pop();
                    if(popped != s.charAt(i))
                        return false;
                    }
                else
                    return false;
            }
         
            
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
        
    }
}