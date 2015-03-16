/**
 * 1. This is easy but easily make things complicated!!
 * Move A's element to the end of A
 * Merge A & B
 */ 
/*public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        for(int i=m-1; i>=0; i--) { A[i+n] = A[i]; }
        
        int index = 0, i = n, j = 0;
        while(i<m+n && j<n)
            A[index++] = (B[j] <= A[i])? B[j++] : A[i++];
        
        while (j < n) 
            A[index++] = B[j++];
        
        // do not need to copy A's remaining.
    }
}*/

/**
 * Do not need to copy at all, we can do it in the oppsite way
 * Put the largest to the end!
 */
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m+n-1, i = m-1, j = n-1;
        while(i>=0 && j>=0) 
            A[index--] = B[j] >= A[i] ? B[j--] : A[i--];
        
        while (j>=0) 
            A[index--] = B[j--];
    }
}
