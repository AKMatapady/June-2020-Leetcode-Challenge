class Solution {
    
    class Node
    {
        boolean isEnd;
        Node[] node = new Node[26];
        String word;
        Node()
        {
            isEnd = false;
            word = null;
        }
    }
    
    Node head;
    List<String> ans;
    char[][] b;
    
    public void addWord(String word)
    {
        Node curr = head;
        for(int i = 0; i < word.length(); i++)
        {
            if(curr.node[word.charAt(i)-'a'] == null)
            {
                curr.node[word.charAt(i)-'a'] = new Node();
                
            }
            curr = curr.node[word.charAt(i)-'a'];
        }
        curr.isEnd = true;
        curr.word = word;
    }
    
    public void check(int x, int y, Node curr)
    {
        char z = b[x][y];
        if(z =='*' || curr.node[z-'a'] == null)
            return;
        
        if(curr.node[z-'a'].word != null)
        {
            ans.add(curr.node[z-'a'].word);
            curr.node[z-'a'].word = null;
        }
        
        b[x][y] = '*';
        
        if(x > 0)
            check(x-1, y, curr.node[z-'a']);
        if(y > 0)
            check(x, y-1, curr.node[z-'a']);
        if(x < b.length-1)
            check(x+1, y, curr.node[z-'a']);
        if(y < b[0].length-1)
            check(x, y+1, curr.node[z-'a']);
        
        b[x][y] = z;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        
        if(words == null || words.length < 1 || board == null || board.length < 1)
            return new ArrayList<String>();
        
        head = new Node();
        b = board;
        for(int i = 0; i < words.length; i++)
        {
            addWord(words[i]);
        }
        ans = new ArrayList();
        
        for(int i = 0; i < b.length; i++)
        {
            for(int j = 0; j < b[0].length; j++)
            {
                check(i, j, head);
            }
        }
        return ans;
    }
}