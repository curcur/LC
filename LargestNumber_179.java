/**
 * Original using a binary tree, not necessary!
 * Sort is enough!
 * but need to define compare carefully...
 */
 
public class Solution {

    public class Compare implements Comparator<String> {
        
        /**
         * My recursive version of compare
         */ 
        /*public int compare(String v1, String v2) {
            int length = (v1.length() < v2.length()) ? v1.length() : v2.length();
	    
            for (int i=0; i<length; i++) {
                if (v1.charAt(i) < v2.charAt(i))    return -1;
                if (v1.charAt(i) > v2.charAt(i))    return 1;
            }
            
            // numbers within [0, length) are the same
            if (v1.length() == v2.length())     return 0;
            
            // XXX substring, no big 'S', it is a recursion
            return v1.length() > length ? compare(v1.substring(length), v2) : compare(v1, v2.substring(length));
        }*/
        
        public int compare(String v1, String v2) {
            
            // XXX Java String comparison CompareTo
            return (v1+v2).compareTo(v2+v1);
        }
    }

    public String largestNumber(int[] num) {
        
        
        List<String> list = new ArrayList<String>();
        
        for(int i : num) {
            list.add(String.valueOf(i));
        }
        
        Compare c = new Compare();  // XXX should not use Compare<String>
        
        Collections.sort(list, c);
        
        String largestNumber = "";
        for (int i = list.size() - 1; i>=0; i--)
            largestNumber += list.get(i);
            
        // XXX corner case, the number is 0.
        if (largestNumber.charAt(0) == '0') return String.valueOf(0);
        else return largestNumber;
        
    }
}
