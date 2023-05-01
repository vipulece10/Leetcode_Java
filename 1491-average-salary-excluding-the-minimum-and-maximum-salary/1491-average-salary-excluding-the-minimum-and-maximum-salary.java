class Solution {
    public double average(int[] salary) {
        int sumSalary = 0;
        int maxSalary = Integer.MIN_VALUE;
        int minSalary = Integer.MAX_VALUE;
        int n = salary.length - 2;
        for(int sal : salary){
            sumSalary += sal;
            maxSalary = Math.max(maxSalary,sal);
            minSalary = Math.min(minSalary,sal);
        }
        
        if(salary.length == 3)
            return (sumSalary - maxSalary - minSalary) * 1.0;
        
        return ((sumSalary - maxSalary - minSalary) * 1.0)/n; 
    }
}