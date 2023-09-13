class Solution {
    public int candy(int[] ratings) {
        int [] leftNeighbour = new int [ratings.length];
        int [] rightNeighbour = new int [ratings.length];
        int [] res = new int [ratings.length];
        int sum = 0;
        
        for(int i =0;i<ratings.length;i++){
            leftNeighbour[i] = 1;
            rightNeighbour[i] = 1;
        }
        
        for(int i =1;i<ratings.length;i++){
            if(ratings[i-1] < ratings[i])
                leftNeighbour[i]=leftNeighbour[i-1] + 1;
        }
        
        for(int i = ratings.length-1;i>0;i--){
            if(ratings[i-1] > ratings[i])
                rightNeighbour[i-1]=rightNeighbour[i] + 1;
        }
        
        for(int i=0;i < ratings.length;i++){
            res[i] = Math.max(leftNeighbour[i],rightNeighbour[i]);
            sum+=res[i];
        }
        return sum;
    }
}