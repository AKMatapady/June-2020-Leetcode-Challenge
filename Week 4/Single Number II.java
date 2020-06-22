class Solution {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length < 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int a = 0, b = 0;
        for(int x : nums)
        {
            a = (a^x)&(~b);
            b = (b^x)&(~a);
        }
        return a;
    }
}