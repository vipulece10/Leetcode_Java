class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterlogs = new ArrayList<>();
        List<String> digitlogs = new ArrayList<>();
        for(String log : logs){
            if(Character.isDigit((log.charAt(log.length() -1)))){
                digitlogs.add(log);
            }
            else{
                letterlogs.add(log);
            }
        }
        
        Collections.sort(letterlogs,new Mycomparator());
        
        String [] res = new String [logs.length];
        for(int i = 0;i<letterlogs.size();i++){
            res[i] = letterlogs.get(i);
        }
        
        for(int i = letterlogs.size();i<logs.length;i++){
            res[i] = digitlogs.get(i-letterlogs.size());
        }
        
        return res;
    }
    
}
class Mycomparator implements Comparator<String>{
    public int compare(String o1,String o2){
        String s1 = o1.substring(o1.indexOf(" ") + 1);
        String s2 = o2.substring(o2.indexOf(" ") + 1);
        return s1.equals(s2) ? o1.compareTo(o2) : s1.compareTo(s2);
    }
}