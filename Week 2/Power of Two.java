class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1)
            return true;
        if(n < 1)
            return false;
        while(n >= 2)
        {
            //System.out.println(n);
            if((n % 2) != 0)
                return false;
            n /=2;
        }
        return true;
    }
}