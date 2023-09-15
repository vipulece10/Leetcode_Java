class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        int i =0;
        while(i<s.length()){
           if (!set.add(s.charAt(i))){
               count++;
               set.clear();   
           }else{
               i++;
           }
        }
        
        return count+1;
    }
}

//    abacaba
// {a:1 b: 1}  count++ {ab}
//{a:3,b:1,c:1} count++ {ac}