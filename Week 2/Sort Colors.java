class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length-1, k = 0;
        while(k<=j)
        {
            if(nums[k] == 0)
            {
                nums[k] = nums[i];
                nums[i] = 0;
                i++;
                k++;
            }
            else if(nums[k] == 1)
            {
                k++;
            }
            else
            {
                nums[k] = nums[j];
                nums[j] = 2;
                j--;
            }
        }
    }
}