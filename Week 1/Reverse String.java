class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length < 2)
            return;
        int len = s.length;
        char temp;
        for(int i = 0, j = len-1; i < (len/2); i++, j--)
        {
            temp = s[j];
            s[j] = s[i];
            s[i] = temp;
        }
        
    }
}