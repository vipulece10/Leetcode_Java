class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] integers = new Integer[rowIndex + 1];
        Arrays.fill(integers, 1);
        for(int row = 0; row < rowIndex; row++) {
            for(int col = row; col > 0; col--) {
                integers[col] += integers[col - 1];
            }
        }
        return Arrays.asList(integers);

        
    }
}