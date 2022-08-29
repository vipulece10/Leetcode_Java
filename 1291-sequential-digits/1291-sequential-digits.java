class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
       // int [] numbers = new int[]{1,2,3,4,5,6,7,8,9};
        String str = "123456789";
       // System.out.println(str.length());
        int start = countDigits(low);
        int end = countDigits(high);
        List <Integer> res = new ArrayList<>();
       // System.out.println(start + " " + end);
        
        while(start <= end){
            for(int i=0;i<str.length()-start+1;i++){
                String temp = str.substring(i,i+start);
               // System.out.println(temp);
                if(low <= Integer.valueOf(temp) 
                    && Integer.valueOf(temp) <= high){
                    res.add(Integer.valueOf(temp));
                }
            }
            
            start++;
        }
        
        return res;
    }
    
    public int countDigits(int n){
        int count =0;
        while(n!=0){
            count++;
            n=n/10;
        }
        
        return count;
    }
}