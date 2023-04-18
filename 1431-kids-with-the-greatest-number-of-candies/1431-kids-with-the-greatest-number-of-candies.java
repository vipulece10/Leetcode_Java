class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List <Boolean> res = new ArrayList<>();
        int maxcandy = -1;
        for(int candy : candies){
            maxcandy = Math.max(maxcandy,candy);
        }
        for(int candy : candies){
            if(candy + extraCandies >= maxcandy){
                res.add(true);
            }
            else{
                res.add(false);
            }
        }
        return res;
    }
}