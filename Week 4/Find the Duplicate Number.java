class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        if(nums.length <= 2)
            return nums[0];
        int slow = 0, fast = 0;
        while(true)
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }
        fast = 0;
        while(true)
        {
            slow = nums[slow];
            fast = nums[fast];
            if(slow == fast)
                return slow;
        }
        //return slow;
    }
}