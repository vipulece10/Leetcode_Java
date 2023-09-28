class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int start = 0;
        int end = arr.length - 1;
        
        while(end - start + 1 > k){
            if(Math.abs(arr[start] - x) > Math.abs(arr[end] - x)){
                start++;
            }else{
                end--;
            }
        }
        System.out.println(start +"  " + end);
        List<Integer> ans = new ArrayList<>();
        for(int i = start;i<=end;i++ ){
            ans.add(arr[i]);
        }
        return ans;
    }
    
}