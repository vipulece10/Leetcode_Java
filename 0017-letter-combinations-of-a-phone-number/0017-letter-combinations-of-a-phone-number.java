class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> res=new ArrayList<>();
        if(digits.length()==0) return res;
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
       // ArrayList<String> res=new ArrayList<>();
      //  StringBuilder sb=new StringBuilder();
        dfs(digits,"",map,res,0);
        return res;
    }
    
    public void dfs(String digits,String sb,Map<Character,String>map,List<String>res,int index){
        System.out.print("  "+digits);
        
    if(index==digits.length()){
        res.add(sb);
        return;
    }
    String letter=map.get(digits.charAt(index));
    System.out.print(letter);
    for(int i=0;i<letter.length();i++) {
        dfs(digits,sb+letter.charAt(i),map,res,index+1);
        //sb.deleteCharAt(sb.length()-1);
    }
}
    
}