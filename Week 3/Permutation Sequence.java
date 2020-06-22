class Solution {
    public String getPermutation(int n, int k) {
        int x = k-1;
        List<Integer> ans = new ArrayList();
        List<Integer> rep = new ArrayList();
        for(int i = 1; i <= n; i++)
        {
            rep.add(i);
            if(x>0)
            {
                ans.add(x % i);
            }
            else
                ans.add(0);
            x /= i;
        }
        Collections.reverse(ans);
        StringBuilder sb = new StringBuilder();
        for(int i : ans)
        {
            sb.append(String.valueOf(rep.get(i)));
            rep.remove((int)i);
        }
        return sb.toString();
    }
}