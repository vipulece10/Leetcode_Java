class Solution {
    public int minSetSize(int[] arr) {
        int size = arr.length;
        int count = 0;
        HashMap <Integer,Integer> hm = new HashMap<>();
        for(int i =0;i<size;i++){
            if(!hm.containsKey(arr[i])){
                hm.put(arr[i],1);
            }else{
                hm.put(arr[i],1+hm.get(arr[i]));
            }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->hm.get(b)-hm.get(a));
        for(Integer key : hm.keySet()){
            pq.add(key);
        }
        
        while(size > arr.length/2){
            size-=hm.get(pq.poll());
            count++;
        }
        
        return count;
    }
}