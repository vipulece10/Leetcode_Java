//import java.util.List;
class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] score:items){
            if(! map.containsKey(score[0])){
                 List<Integer> lst = new ArrayList<>();
                 lst.add(score[1]);
                 map.put(score[0],lst);                
            }
            else{
                List<Integer> lst = new ArrayList<>();
                 lst = map.get(score[0]);
                System.out.println(lst.size());
                lst.add(score[1]);
                map.put(score[0],lst);
            }
        }
        
        int [][] res = new int [map.size()][2]; 
        int index=0;
        for(Integer key : map.keySet()){
            int avg =0;
            List <Integer> student_scores = new ArrayList<>();
            student_scores = map.get(key);
            Collections.sort(student_scores);
            Collections.reverse(student_scores);
            
            for(int i =0;i<5;i++){
                System.out.println(key+" " + student_scores.get(i));
                avg+=student_scores.get(i);
            }
            
            res[index][0]=key;
            res[index][1]=avg/5;
            
            index++;
        }
        
        return res;
    }
}