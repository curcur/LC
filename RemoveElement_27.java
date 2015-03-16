public class Solution {
    public int removeElement(int[] A, int elem) {
        if (A.length == 0)  return 0;     // XXXXXXX this is wrong again!
        
        int i=0, j=A.length-1;
        while(i<j) {
            while(A[j] == elem && i<j) j--;
            while(A[i] != elem && i<j) i++;
            
            if (i<j) { int t = A[i]; A[i] = A[j]; A[j] = t; }
        }
        if (A[i] == elem) i--;
        return i+1;
    }
}
