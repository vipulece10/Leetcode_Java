class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> rows = new ArrayList<>();
            for(int j=0;j<i+1;j++){
                if(j == 0 || j == i){
                    rows.add(1);
                }
                else{
                    int a =  res.get(i-1).get(j-1);
                    int b = res.get(i-1).get(j);
                    rows.add(a + b);
                }
            }
            res.add(rows);
        }
        return res;
    }
}