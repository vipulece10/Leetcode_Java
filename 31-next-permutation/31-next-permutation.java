class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        int i=nums.length-1;
        while(i>0){
            if(nums[i-1]<nums[i]){
                index=i;
                break;
            }
            i--;
        }
        System.out.print("index  "+index);
        if(index==-1){
            reverse(nums,0,nums.length-1);
        }
        else{
           int j=nums.length-1;
        while(nums[j]<=nums[index-1]){
            j--;
        }
           // System.out.print("j  "+j);
            swap(nums,index-1,j);
            reverse(nums,index,nums.length-1);
        }
        
            
        //System.out.print("j  "+j);
    }
    public void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    
    public void reverse(int[] nums,int i,int j){
        j=nums.length-1;
        while(i<=j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }
}