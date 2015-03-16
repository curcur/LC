/**
 * The most naive way is O(n^2) or sorting better nlog(n), but in fact, 
 * We can do it in O(n) time
 */

/**
 * One pass, swap 0 to the left, and 2 to te right
 */

public class Solution {
    public void sortColors(int[] A) {
        int l = 0, r = A.length-1, index = l;
        
        while(index <= r) {
            if (A[index] == 0) { swap(A, l, index); l++; }
            else if (A[index] == 1) { index++; }
            else if (A[index] == 2) { swap(A, index, r); r--; }
            else { System.err.println("Input Error"); }
            
            index = Math.max(l, index);
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i]; A[i] = A[j]; A[j] = temp;
    }
            
        
}
