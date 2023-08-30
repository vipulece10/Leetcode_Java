class Solution {
    public String decodeString(String s) {
        Stack<Integer> st_num = new Stack<>();
        Stack<StringBuilder> st_string = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int k = 0;
        s=s.trim();
        for(int i =0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))
                 k = k*10 + s.charAt(i) - '0';
            else if(Character.isAlphabetic(s.charAt(i))){
                currentString.append(s.charAt(i));
            }
            else if(s.charAt(i) =='['){
                st_num.add(k);
                st_string.add(currentString);
                currentString = new StringBuilder();
                k = 0;
            }
            else{
                StringBuilder decodedString = st_string.pop();
                 int count =st_num.pop();
                // StringBuilder sb  = new StringBuilder();
               // System.out.println(currentString);
                 while(count > 0){
                    decodedString.append(currentString);
                    count--;
                 }
                currentString =  decodedString;
            }
        }
        return currentString.toString();
    }
}