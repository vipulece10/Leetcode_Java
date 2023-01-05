class Solution {
    public boolean confusingNumber(int n) {
        HashMap <Integer,Integer> rotation_map = new HashMap<>();
        rotation_map.put(0,0);
        rotation_map.put(1,1);
        rotation_map.put(6,9);
        rotation_map.put(8,8);
        rotation_map.put(9,6);
        int res =0;
        int number = n;
        while(n > 0){
            int digit = n % 10;
            if(!rotation_map.containsKey(digit))
                return false;
            else{
                int rotate = rotation_map.get(digit);
                res = res * 10 + rotate;
            }
            n = n / 10;
        }
       // StringBuilder sb = new StringBuilder();
       // sb.append(res);
       // System.out.println("res" + res);
       // String ans = sb.reverse().toString();
       // System.out.println("ans" + ans);
        if(number == res)
            return false;
        return true;
    }
}