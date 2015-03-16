/**
 * There are several different ways of designing, depending on the requirement of operations, and also the space requirements.
 * 1. If you wanna the find operation be quick, the fastest way is using a hash table to store all pairs of sum
 * the space is O(n^2), the find is quick, which is O(1), and the add is O(n), because for each input element, we need to
 * calculate the sum for each element already exists. 
 * 
 * 2. If you wanna add to be quick, you can use unsorted array, linkedlist, or hash
 * 
 * ....
 * 
 * 3. Other thing we wanna consider is extensiblitity
 * Other common operations like delete, find a value
 * 
 * 4. Scalablilty, the size of number might be small, but if the number goes to really large that can not fit into the memory?
 * We need to think of the page size, and so on...
 */

public class TwoSum {
    
    // the input integer, and the count of the integer {3}  target: 6
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    
    public void add(int number) {
        Integer count = hmap.get(Integer.valueOf(number));
        if (count == null)  hmap.put(Integer.valueOf(number), Integer.valueOf(1));
        else hmap.put(Integer.valueOf(number), Integer.valueOf(count.intValue() + 1));
	}

	public boolean find(int value) {
	    
	    for (Integer itg : hmap.keySet()) {
	        int remain = value - itg.intValue();
	        Integer remainhash = hmap.get(Integer.valueOf(remain));
	        
	        if (remainhash != null) {
	            if (remain != itg.intValue())   return true;
	            if (remainhash.intValue() >= 2)    return true;     // XXXXX  >=2, original I wrote >2
	        } 
	    }
	    return false;
	}
}
