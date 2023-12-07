class Solution {
    public String minRemoveToMakeValid(String s) {
        int count=0;
        char[]str=s.toCharArray();
        //Iterate String from left to right
        //check for opening and closing parantheses
        for(int i=0;i<str.length;i++){
            if(str[i]=='('){
                count++;
            }
            if(str[i]==')'){
                if(count>0){
                    count--;
                }
                else{
                    str[i]='0';
                }
            }
        }
        
        //Iterate String from right to left
        //check for opening and closing braces
        count=0;
        for(int i=str.length-1;i>=0;i--){
            if(str[i]==')'){
                count++;
            }
            if(str[i]=='('){
                if(count>0){
                    count--;
                }
                else{
                    str[i]='0';
                }
            }
        }
        
        //Iterate on String to remove '0' and append it to result
        
        StringBuilder res=new StringBuilder();
        for(int i=0;i<str.length;i++){
            if(str[i]!='0'){
                res.append(str[i]);
            }
            // else{
            //     continue;
            // }
        }
        return res.toString();
        
    }
}