class Solution {
    
    char[][] b;
    Set<Integer> st;
    
    public void DFS_min(int x)
    {
        int r1 = x / b[0].length;
        int c1 = x % b[0].length;
        if(r1 > 0 && b[r1-1][c1] == 'O' && !st.contains(x-b[0].length))
        {
            st.add(x-b[0].length);
            DFS_min(x-b[0].length);
        }
        if(r1 < (b.length-1) && b[r1+1][c1] == 'O' && !st.contains(x+b[0].length))
        {
            st.add(x+b[0].length);
            DFS_min(x+b[0].length);
        }
        if(c1 > 0 && b[r1][c1-1] == 'O' && !st.contains(x-1))
        {
            st.add(x-1);
            DFS_min(x-1);
        }
        if(c1 < (b[0].length-1) && b[r1][c1+1] == 'O' && !st.contains(x+1))
        {
            st.add(x+1);
            DFS_min(x+1);
        }
    }
    
    public void solve(char[][] board) {
        if(board == null || board.length < 1)
            return;
        b = board;
        int r = board.length;
        int c = board[0].length;
        //visited = new boolean[r][c];
        st = new HashSet();
        Deque<Integer> q = new LinkedList();
        for(int i = 0; i < r; i++)
        {
            if(board[i][0] == 'O')
                q.add(i*c);
            if(board[i][c-1] == 'O')
                q.add((i*c)+(c-1));
        }
        
        for(int j = 1; j < (c-1); j++)
        {
            if(board[0][j] == 'O')
                q.add(j);
            if(board[r-1][j] == 'O')
                q.add(((r-1)*c)+j);
        }
        
        while(!q.isEmpty())
        {
            int x = q.poll();
            int r1 = x / c;
            int c1 = x % c;
            if(!st.contains(x))
            {
                st.add(x);
                DFS_min(x);
            }
        }
        
        for(int i = 0; i < r; i++)
        {
            for(int j = 0; j < c; j++)
            {
                if(!st.contains((i*c)+j))
                {
                    board[i][j] = 'X';
                }
            }
        }
        
    }
}