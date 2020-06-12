import java.util.*;

class RandomizedSet {
    
    Set<Integer> st;
    List<Integer> l;
    Random r;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        st = new HashSet();
        l = new ArrayList<Integer>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ret = st.contains(val);
        if(!ret)
        {
            st.add(val);
            l.add(val);
        }        
        return !ret;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean ret = st.contains(val);
        if(ret)
        {
            st.remove(val);
            l.remove(((Integer)val));
        }        
        return ret;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int len = l.size();
        if(len > 0)
        {
            int index = r.nextInt(len);
            return l.get(index);
        }
        return 0;
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */