/***
 * The middle number. If there are two middle numbers, you average them
 */
public class Solution {
    
    /***
     * Every time cut half of the short array length from A & B
     * Smaller than the smaller median can be cut
     * Larger than the larger median can be cut
     * untilt he short array has only 2 numbers.
     * However the corner case is crazy, not suggest using this way
     * so what we do is to binary search the position of those 2 numbers in the remaining longer array
     * and return the median.
     */
    /* 
    public double findMedianSortedArrays(int A[], int B[]) {
        if (A.length == 0)  return median(B, 0, B.length-1);
        if (B.length == 0)  return median(A, 0, A.length-1);
        
        int s[], l[];
        if (A.length <= B.length) { s = A; l = B; }
        else { s = B; l = A; }
        
        int lefts = 0, rights = s.length-1, leftl = 0, rightl = l.length-1;
        int mids, midl, slide;
        
        // until the shortest have two elements
        while (lefts < rights - 1) {
            mids = (lefts + rights)/2; midl = (leftl + rightl)/2;
            slide = (rights - lefts)/2; // sliding is <= half of the short
            if (s[mids] < l[midl]) {
                lefts += slide; rightl -= slide;
            } else if (s[mids] > l[midl]) {
                rights -= slide; leftl += slide;
            } else {  // they are the same
                lefts += slide; rightl -= slide;
                rights -= slide; leftl += slide;
            }
        }
        
        // corner cases drive me crazy, using binary insert instead. 
        // This is for correctness verficication
        int length = rightl - leftl + 1 + rights - lefts + 1;
        int remain[] = new int[length];
        
        int i=leftl, j=lefts, index=0;
        for(; i<=rightl && j<=rights; index++) {
            if (l[i] < s[j])    {   remain[index] = l[i]; i++;  }
            else {  remain[index] = s[j]; j++; }
        }
        
        if (i > rightl) {
            for (; j<=rights; j++, index++) {
                remain[index] = s[j];
            }
        } else if (j > rights) {
            for(; i<=rightl; i++, index++) {
                remain[index] = l[i];
            }
        } else {
            System.out.println("Somthing is Wrong!");
        }
        
        return median(remain, 0, length-1);
        
    }*/
    
    public double median(int arr[], int start, int end) {
        int idx = (start + end) / 2;
        if ((end - start) % 2 == 0 ) { return arr[idx];     // odd
        } else {    return (arr[idx] + arr[idx+1])/ 2.0 ;   // even 
        }
        
    }

    public double findMedianSortedArrays(int A[], int B[]) {
        // if (A.length == 0)  return median(B, 0, B.length-1);
        // if (B.length == 0)  return median(A, 0, A.length-1);
        
        int totallength = A.length + B.length;
        int k = (A.length + B.length + 1) / 2;  // the k-th smallest
        if (totallength % 2 != 0) { // odd
            return findkth(A, B, k);
        }else {
            return (findkth(A, B, k) + findkth(A, B, k+1))/2.0;     // XXXXX 2.0 because of double
        }
        
    }
    
    // arrays, k
    public int findkth(int A[], int B[], int kth) {
        int s[], l[];
        
        if (A.length >= B.length)   {   l = A; s = B;   }
        else {  l = B; s = A; }
        
        int sleft = 0, lleft = 0;   // the left index of l and s
        int sk = 0, lk = 0;         // the (k-1)/2 number of s & l
        int k = kth;
        
        while (true) {
            if (s.length - sleft < 1)  return l[k-1+lleft];     // the shorter one is empty
            if (k == 1) return Math.min(s[sleft], l[lleft]);
            
            int spart = Math.min(k/2, s.length-sleft);
            int lpart = k - spart;
            sk = s[spart+sleft-1]; lk = l[lpart+lleft-1];
            
            if (sk == lk)   return sk;
            if (sk < lk)    {   sleft += spart; k -= spart; }
            else            {   lleft += lpart; k -= lpart; }
            
            if (s.length-sleft > l.length-lleft)    {           // XXX need to be the length - begin index
                // exchange
                int temparray[] = s; s = l; l = temparray;
                int templeft = sleft; sleft = lleft; lleft = templeft;
            }
        }
    }
}
