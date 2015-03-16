/**
 * -- use sorting, and binary search n(logn) + log(n)
 * -- use hash, O(n) time, but need extra O(n) space
 * -- I have an idea, put every integer on its index, >length or <=0, just ignore
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i=0; i<A.length; i++) {
            // XXXXXXX A[i] != A[A[i]-1]  in the case of [1 1]
            while (A[i] > 0 && A[i] <= A.length // && A[i] != i+1 can omit
                        && A[i] != A[A[i]-1])  {
                int temp = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = temp;
            }
        }
        
        int i=0;
        for(; i<A.length; i++) {
            if (A[i] != i+1)    break;
        }
        return i+1;
    }
}
