class Solution {
    int[] s;
    Random r;
    public Solution(int[] w) {
        s = new int[w.length];
        r = new Random();
        s[0] = w[0];
        for(int i = 1; i < w.length; i++)
        {
            s[i] = s[i-1]+w[i];
        }
    }
    
    public int pickIndex() {
        
        int index = r.nextInt(s[s.length-1])+1;
        int start = 0, end = s.length - 1;
        
        while(start <= end)
        {
	    // to avoid overflows
            int mid = start + (end - start)/2;
            if(s[mid] == index)
            {
                return mid;
            }
            if(s[mid] > index)
            {
                end = mid - 1;
            }
            else
                start = mid + 1;
        }
        
        return (start);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */