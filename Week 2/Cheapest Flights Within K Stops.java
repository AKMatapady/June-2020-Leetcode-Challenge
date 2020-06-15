class Solution {
    
    class Edge
    {
        int src;
        int dst;
        int weight;
        Edge(int s, int d, int w)
        {
            src = s;
            dst = d;
            weight = w;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(src == dst)
            return 0;
        
        if(flights == null || flights.length < 1)
            return -1;
        int len = flights.length;
        HashMap<Integer, List<Edge>> mp = new HashMap();
        for(int i = 0; i < len; i++)
        {
            Edge e = new Edge(flights[i][0], flights[i][1], flights[i][2]);
            List<Edge> l = mp.getOrDefault(flights[i][0], new ArrayList<Edge>());
            l.add(e);
            mp.put(flights[i][0], l);
        }
        
        int price = Integer.MAX_VALUE;
        Queue<Edge> q = new LinkedList<Edge>();
        //boolean[] visited = new boolean[n];
        //Arrays.fill(visited, false);
        
        List<Edge> l = mp.getOrDefault(src, new ArrayList<Edge>());
        for(int i = 0; i < l.size(); i++)
        {
            q.add(l.get(i));
            //System.out.println("src: "+ l.get(i).src + ", dst: " + l.get(i).dst);
        }
        
        q.add(null);
        //visited[src] = true;
        
        while(K >= 0 && !q.isEmpty())
        {
            // for(int i = 0; i < n; i++)
            // {
            //     if(visited[i])
            //         System.out.print("1 ");
            //     else
            //         System.out.print("0 ");                
            // }
            // System.out.println();
            
            
            if(q.peek() == null)
            {
                q.poll();
                q.add(null);
                K--;
                continue;
            }
            
            Edge e = new Edge(q.peek().src, q.peek().dst, q.peek().weight);
            q.poll();
            if(dst == e.dst)
            {
                //System.out.println("price: " + price + ", weight: " + e.weight);
                if(price > e.weight)
                    price = e.weight;
                continue;
            }
            
            // if(visited[e.dst])
            // {
            //     continue;
            // }
            
            List<Edge> l2 = mp.getOrDefault(e.dst, new ArrayList<Edge>());
            for(int i = 0; i < l2.size(); i++)
            {
                Edge sub = new Edge(l2.get(i).src, l2.get(i).dst, l2.get(i).weight);
                
                if(/*!visited[sub.dst] &&*/ (price - e.weight)>sub.weight)
                {                    
                    sub.weight += e.weight;
                    //System.out.println("new weight: " + sub.weight + " for " + sub.src + " " + sub.dst);
                    q.add(sub);
                    //System.out.println("src: "+ l2.get(i).src + ", dst: " + l2.get(i).dst);
                }                
            }
        }
        
        if(price == Integer.MAX_VALUE)
            return -1;
        return price;
    }
}