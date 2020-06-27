class Solution {
    
    public int numSquares(int n) {
        if(n < 4)
            return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++)
        {
            dp[i] = i;
            for(int j = 1; j <= Math.sqrt(i)+1; j++)
            {
                if(j*j <= i)
                {
                    //System.out.println("n: " + i + ", j: " + j + ", dp: " + dp[i] + " : Before");
                    dp[i] = Math.min(dp[i], 1 + dp[i - (j*j)]);
                    //System.out.println("n: " + i + ", j: " + j  + ", dp: " + dp[i] + " : After");
                }
                else
                    break;
            }
            
        }
        return dp[n];
    }
}