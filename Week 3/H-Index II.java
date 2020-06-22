class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length < 1)
            return 0;
        int len = citations.length;
        if(citations[len-1] < 1)
            return 0;
        if(len == 1)
        {
            if(citations[0]>=1)
                return 1;
            return 0;
        }
        int start = 0, end = len-1;
        while(start < end)
        {
            int mid = start + (end - start)/2;
            if(citations[mid] >= (len-mid))
            {
                end = mid;
            }
            else
                start = mid+1;
        }
        return len-start;
    }
}