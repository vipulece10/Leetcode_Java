class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int amount = income;
        double totaltax =0.000;
        if(amount == 0)
            return 0.0000;
        else if(amount >= brackets[0][0]){
         totaltax = (brackets[0][0] * brackets[0][1])/100.0;
         amount = amount - brackets[0][0];
        }
        else{
            totaltax = (amount * brackets[0][1])/100.0;
            return totaltax;
        }
        
        for(int i =1;i< brackets.length;i++){
            if(amount == 0)
                return totaltax;
            else if(amount >= (brackets[i][0]-brackets[i-1][0])){
                double tax = ((brackets[i][0] - brackets[i-1][0]) * brackets[i][1])/100.0;
                totaltax= totaltax + tax;
                amount= amount - (brackets[i][0]-brackets[i-1][0]);
                System.out.println(i);
            }
            else if (amount < brackets[i][0]-brackets[i-1][0]){
                totaltax+= (amount * brackets[i][1])/100.0;
                amount = 0;
            }
        }
        
        return totaltax;
        
    }
}