class Solution {
    public int lastStoneWeight(int[] stones) {
        int i=0;
        int j=stones.length-1;
        while(i!=j){
            Arrays.sort(stones);
         
            while(stones[i]==-1 && i<j)
                i++;
            if (i==j && stones[i]==-1)
                return 0;
            else if (i==j && stones[i]!=-1)
                return stones[i];
            if(stones[j-1]==stones[j]){
                stones[j-1]=-1;
                stones[j]=-1;
            }
            else if(stones[j-1]!=stones[j]){
                stones[j]=stones[j]-stones[j-1];
                stones[j-1]=-1;
            }
        }
      //  System.out.println(stones[i]);
        return stones[i];
    }
}