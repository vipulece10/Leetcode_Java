class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        /*
        https://leetcode.com/problems/find-good-days-to-rob-the-bank/discuss/1623435/O(n)-Java-solution-easy-understanding
        */
        int[] nonIncreasingCount =new int[security.length];
        int[] nonDescreasingCount = new int[security.length];
        List<Integer> lst = new ArrayList<>();
        for(int i = 1;i<security.length;i++){
            if(security[i] <= security[i-1]){
                nonIncreasingCount[i] = nonIncreasingCount[i-1] + 1;
            }else{
                nonIncreasingCount[i] = 0;
            }
        }
        
        for(int i = security.length-2;i >= 0;i--){
            if(security[i+1] >= security[i]){
                nonDescreasingCount[i] = nonDescreasingCount[i+1] +1;
            }else{
                nonDescreasingCount[i] = 0;
            }
        }
        
        for(int i = time;i<security.length - time;i++){
            if(nonIncreasingCount[i] >= time && nonDescreasingCount[i] >= time){
                lst.add(i);
            }
        }
        return lst;
    }
}