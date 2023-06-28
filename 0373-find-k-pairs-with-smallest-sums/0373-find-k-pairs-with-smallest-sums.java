class Pair{
    int x;
    int y;
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue <int[]> pq=new PriorityQueue<>(
        (a,b)->(a[0]-b[0])
        );
        
        List<List<Integer>> res = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        
        pq.add(new int[]{nums1[0] +nums2[0],0,0});
        String index = "0$0";
        set.add(index);
        
        while(k > 0 && !pq.isEmpty()){
            int [] top = pq.poll();
            int i = top[1];
            int j = top[2];
           // List<Integer> lst =new 
            String indexOne = String.valueOf(i+1)+"$"+String.valueOf(j);
            String indexTwo = String.valueOf(i)+"$"+String.valueOf(j+1);
            res.add(Arrays.asList(new Integer[]{nums1[i],nums2[j]}));
            if(i+1 < m && !set.contains(indexOne)){
                pq.add(new int[]{nums1[i+1] +nums2[j],i+1,j});
                
                //set.add(new Pair(i+1,j));
                set.add(indexOne);
            }
            
            if(j+1 < n && !set.contains(indexTwo)){
                pq.add(new int[]{nums1[i] + nums2[j+1],i,j+1});
              //  set.add(new Pair(i,j+1));
                set.add(indexTwo);
            }
            k--;
        }
            
            return res;
    }
}