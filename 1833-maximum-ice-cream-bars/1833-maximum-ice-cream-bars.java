class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int n = costs.length;
        int count =0;
        int money = coins;
        for(int i =0;i<n;i++){
            if(money >= costs[i]){
            money -= costs[i];
            count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}