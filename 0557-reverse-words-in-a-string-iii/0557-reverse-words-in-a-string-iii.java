class Solution {
    public String reverseWords(String s) {
        int start = 0;
        char [] str = s.toCharArray();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == ' '){
                reverse(start,i-1,str);
                start = i+1;
            }
            else if(i == s.length() - 1){
                reverse(start,i,str);
            }
        }
        for(int i = 0;i<str.length;i++){
            System.out.print(" " + str[i] + " ");
        }
        return String.valueOf(str);
    }
    private void reverse(int start,int end,char [] s){
        int i = start;
        int j = end;
        while(i < j){
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                i++;
                j--;
        }
    }
}