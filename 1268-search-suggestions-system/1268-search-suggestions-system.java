class Solution {
    /*
    https://youtu.be/37KddCEdv3s
    https://leetcode.com/problems/search-suggestions-system/discuss/510681/Java-super-easy-and-clean-solution-Beats-95-time-and-100-space
    */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        int n = products.length;
        
        List<String> possibleProducts = new ArrayList<>();
        for(String product : products){
            possibleProducts.add(product);
        }
        for(int i = 0;i<searchWord.length();i++){
            List<String> filteredResult = new ArrayList<>();
            for(String product : possibleProducts){
                if(i< product.length() && product.charAt(i) == searchWord.charAt(i)){
                    filteredResult.add(product);
                }
            }
            
            int count = 0;
            List<String> intermediateResult = new ArrayList<>();
            for(int j = 0;j<filteredResult.size() && count < 3;j++){
                intermediateResult.add(filteredResult.get(j));
                count++;
            }
            ans.add(intermediateResult);
            possibleProducts = filteredResult;
        }
        return ans;
    }
    
}