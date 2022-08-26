class Solution {
    public int strStr(String haystack, String needle) {
        
        int i = 0;
        int j = 0;
        int size = needle.length();
        
        if(needle.length() > haystack.length())
            return -1;
        while(j<haystack.length()){
            j=i+size;
            String temp = haystack.substring(i,j);
            System.out.println(temp);
            if (temp.equals(needle)){
                return i;
            }
            i++;
        }
        return -1;
    }
}