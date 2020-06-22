class Solution {
    public String longestDupSubstring(String S) {
        if(S == null || S.length() < 2)
            return "";
        int len = S.length();
        int start = 1, end = len;
        int index = -1;
        while(start <= end)
        {
            boolean flag = false;
            int mid = start + (end - start)/2;
            Set<Long> st = new HashSet();
            long hcode = 0;
            long significantBitValue = 1;
            //int prime  = 1000000007;
            long prime  = (long)(Math.pow(2, 31)-1);
            //long prime  = (long)(Math.pow(2, 32));
            //maynot be sufficient -> need to check if multiple strings get assigned to same bucket

            long max = 26;
            //for(int i = 1; i < mid; i++)
                
            for(int i = 0; i < mid; i++)
            {
                hcode = (int)(((hcode * max) + (S.charAt(i) - 'a')) % prime);
                significantBitValue = (int)((significantBitValue * max) % prime);
            }
            st.add(hcode);
            System.out.println("start: " + start + ", mid: " + mid + ", end: " + end + ", SB: " + significantBitValue);
            //System.out.println("hcode: " + hcode);
            for(int i = 1; i <= (len - mid); i++)
            {
                //int x = mp.getOrDefault(S.substring(i, i+mid), 0);
                long temp = ((((hcode*max - (((long)significantBitValue) * (long)(S.charAt(i-1)-'a')))%prime)+prime)%prime);
                hcode = (int)((temp + (S.charAt(i+mid-1)-'a'))%prime);
                // if(hcode < 0)
                //     hcode += prime;
                //System.out.println("hcode: " + hcode);
                if(st.contains(hcode))
                {
                    start = mid+1;
                    //if(dup.length() < mid)
                    //    dup = S.substring(i, i+mid);
                    //System.out.println(dup);
                    flag = true;
                    break;
                }
                st.add(hcode);
            }
            if(flag)
                continue;
            end = mid - 1;
        }
        System.out.println(start-1);
        start--;
        if(start < 1)
            return "";
        Set<Integer> st = new HashSet();
        int hcode = 0;
        int significantBitValue = 1;
        //int prime  = 1000000007;
        long prime  = (long)Math.pow(2, 32);

        long max = 26;
        for(int i = 1; i < start; i++)
            significantBitValue = (int)((significantBitValue * max) % prime);
        for(int i = 0; i < start; i++)
        {
            hcode = (int)(((hcode * max) + (S.charAt(i) - 'a')) % prime);
        }
        st.add(hcode);
        //System.out.println("start: " + start + ", mid: " + mid + ", end: " + end + ", SB: " + significantBitValue);
        //System.out.println("hcode: " + hcode);
        for(int i = 1; i <= (len - start); i++)
        {
            //int x = mp.getOrDefault(S.substring(i, i+mid), 0);
            hcode = (int)(((hcode - (((long)significantBitValue) * (S.charAt(i-1)-'a')))*max )%prime);
            hcode = (int)((hcode + (S.charAt(i+start-1)-'a'))%prime);
            if(hcode < 0)
                hcode += prime;
            //System.out.println("hcode: " + hcode);
            if(st.contains(hcode))
            {
                index = i;
                break;
            }
            else
                st.add(hcode);
        }
        //redundant check
        if(index < 0)
            return "";
        
        System.out.println("start: " + index + ", len: " + start + ", tt: " + S.length());
        
        return S.substring(index, index+start);
    }
}