class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() < 1)
            return true;
        if(t == null)
            return false;
        if(s.length() > t.length())
            return false;
        if(s.length() == t.length())
            return s.equals(t);
        int len = t.length();
        int len2 = s.length();
        int j = 0;
        for(int i = 0; i < len; i++)
        {
            if(s.charAt(j) == t.charAt(i))
            {
                j++;
            }
            if(j == len2)
                return true;
        }
        return false;
    }
}