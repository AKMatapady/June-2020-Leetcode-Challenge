class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        if(nums == null || nums.length < 1)
            return new ArrayList<Integer>();
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        int[] prev_pointer = new int[len];
        int index = 0;
        
        //all numbers divide themselves
        Arrays.fill(dp, 1);
        //no prev pointer in beginning
        Arrays.fill(prev_pointer, -1);
        
        for(int i = 1; i < len; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(nums[i] % nums[j] == 0 && dp[i] < (dp[j]+1))
                {
                    prev_pointer[i] = j;
                    dp[i] = dp[j]+1;
                }
            }
            if(dp[i] > dp[index])
                index = i;  //stroe the index with max divisors
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        while(index >= 0)
        {
            ans.add(nums[index]);
            index = prev_pointer[index];
        }
        Collections.reverse(ans);
        return ans;
    }
}