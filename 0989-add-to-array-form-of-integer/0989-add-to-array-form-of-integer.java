class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry=0;
        int i = num.length -1;
        while(i >= 0 || k > 0){
            int sum = carry + k % 10;
            if(i>=0){
                sum += num[i];
                i--;
            }
            res.add(sum % 10);
            carry = sum / 10;
            k = k/10;
        }
        if(carry != 0)
            res.add(carry);
        Collections.reverse(res);
        return res;
    }
}