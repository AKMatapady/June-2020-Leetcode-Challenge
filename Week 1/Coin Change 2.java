class Solution {
    public int change(int amount, int[] coins) {
        if(amount < 1)
            return 1;
        if(coins == null || coins.length < 1)
            return 0;
                
        //coins = Arrays.stream(coins).boxed().sorted((a, b) -> a.compareTo(b)).mapToInt(i -> i).toArray();
                       
        int len = coins.length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[amount+1][len+1];
        for( int i = 0; i <= len; i++)
        {
            dp[0][i] = 1;
            if(i < len && coins[i] < min)
                min = coins[i];
        }
        
        if(amount < min)
          return 0;
        
        for( int i = 1; i <= amount; i++)
            dp[i][0] = 0;
        
        for( int i = 1; i <= amount; i++)
        {
            for( int j = 0; j < len; j++)
            {
                //int x = i/coins[j];
                //c -> consider
                int c = 0, nc = 0;
                if(i - coins[j] >= 0)
                    c = dp[i - coins[j]][j+1];
                nc = dp[i][j];
                dp[i][j+1] = c + nc;
            }
        }
        
        return dp[amount][len];
    }
}