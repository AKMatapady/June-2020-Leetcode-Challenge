class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length < 1)
            return people;
        
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0])
                return a[1] - b[1];
            return b[0] - a[0];
        });
        
        int len = people.length;
        Stack<int[]> st = new Stack<int[]>();
        Stack<int[]> s2 = new Stack();
        st.push(people[0]);
        for(int i = 1; i < len; i++)
        {
            int x = people[i][0];
            int y = people[i][1];
            int pos = 0;
            while(pos < y)
            {
                int[] t = st.pop(); 
                if(t[0]>=x)
                    pos++;
                s2.push(t);
            }
            st.push(people[i]);
            while(s2.size() > 0)
            {
                st.push(s2.pop());
            }
        }
        int[][] ans = new int[len][2];
        for(int i = 0; i < len; i++)
        {
            int[] t = st.pop(); 
            ans[i][0] = t[0];
            ans[i][1] = t[1];
        }
        return ans;
    }
}