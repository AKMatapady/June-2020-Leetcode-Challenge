class Solution {
    
    class cost
    {
        int a;
        int b;
        int index;
        public cost(int x, int y, int z)
        {
            a = x; b = y; index = z;
        }
    }
    
    public int twoCitySchedCost(int[][] costs) {
        
        if(costs == null || costs.length < 1)
            return 0;
        
        PriorityQueue<cost> pq = new PriorityQueue<cost>(new Comparator<cost>(){
           public int compare(cost a, cost b)
           {
               return (a.a-a.b)-(b.a-b.b);
           }
        });
        
        int len = costs.length;
        
        for(int i = 0; i < len; i++)
        {
            cost obj = new cost(costs[i][0], costs[i][1], i);
            pq.add(obj);
        }
        int min_cost = 0;
        
        for(int i = 0; i < len; i++)
        {
            cost obj = pq.poll();
            if( i < len/2)
                min_cost += costs[obj.index][0];
            else
                min_cost += costs[obj.index][1];
        }
        return min_cost;
    }
}