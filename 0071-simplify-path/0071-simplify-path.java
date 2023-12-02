class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack=new Stack<String>();
        String[] tokens=path.split("/");
        
        for(String token:tokens){
            if(token.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }
            else if(token.equals(".") || token.isEmpty()){
                continue;
            }
            else{
                stack.push(token);
            }
        }
        StringBuilder res=new StringBuilder();
       // while(!stack.isEmpty()){
       //     res.append("/");
       //     res.append(stack.pop());
       //     res.append("/");
       // }
        
        for(String element :stack){
            res.append("/");
            res.append(element);
           // res.append("/");
        }
        
        
        return res.length()>0 ? res.toString():res.append("/").toString();
        
        
    }
}