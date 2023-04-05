class Solution {
    public int compress(char[] chars) {
        String res = "";
        int i = 0;
        int j = 0;
        while(j < chars.length){
            while(j < chars.length && chars[j] == chars[i]){
                j++;
            }
            if((j-i) > 1){
                res += String.valueOf(chars[i]) + String.valueOf(j-i);
            }
            else{
                res += String.valueOf(chars[i]);
            }
            System.out.println(i +" " + j);
            i=j;
        }
        for(int k =0;k<res.length();k++){
            chars[k] = res.charAt(k);
        }
        return res.length();
    }
}