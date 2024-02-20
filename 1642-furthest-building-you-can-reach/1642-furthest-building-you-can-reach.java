class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //https://youtu.be/dUkdAjY23p8
        /*         0  1 2 3 4  5  6 7 8
        heights = [4,12,2,7,3,18,20,3,19], bricks = 10, ladders = 2
        4,12->L
        12,2-> 0
        2,7-> 5
        7,3-> 0
        3,18-> L
        18,20-> 2
        20,3-> 0
        3->19->        
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);
        int n = heights.length;
        int i = 0;
        for(;i < n-1;i++){
            if(heights[i+1] <= heights[i])
                continue;
            
            int diff = heights[i+1] - heights[i];
            
            if(bricks >= diff){
                bricks -= diff;
                pq.add(diff);
            }
            else if(ladders > 0){
                if(!pq.isEmpty()){
                    int prevMaxBrick = pq.peek();
                    if(prevMaxBrick > diff){
                        bricks += prevMaxBrick;
                        pq.poll();
                        bricks -= diff;
                        pq.add(diff);
                        ladders--;
                    }else{
                        ladders--;
                    }
                }else{
                    ladders--;
                }
            }else{
                break;
            }
        }
        return i;
    }
}