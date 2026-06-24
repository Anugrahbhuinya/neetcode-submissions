class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums,0,nums.length-1);
        return nums;
    }

    private void quicksort(int[] nums,int low,int high){
        if(low<high){
            int pivotIndex = partition(nums,low,high);

            quicksort(nums,low,pivotIndex-1);
            quicksort(nums,pivotIndex+1,high);
        } 
    }

    private int partition(int nums[],int low,int high){
        int pivot = nums[high];
        int i = low-1;

        for(int j= low;j<high;j++){
            if(nums[j]<=pivot){
                i++;
                swap(nums,i,j);
            }
        }

        swap(nums,i+1,high);
        return i+1;
    }

    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}