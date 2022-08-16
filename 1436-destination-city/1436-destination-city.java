class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        String res = "";
        for(int i =0;i<paths.size();i++){
            set.add(paths.get(i).get(1));
        }
        
        for(int i =0;i<paths.size();i++){
            set.remove(paths.get(i).get(0));
        }
        
        for(String e : set)
            res = e;
        
        return res;
        
    }
}