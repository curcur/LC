/**
 * Using right as criteria
 */
/*public class Solution {
    public int findMin(int[] num) {
        int l = 0, r = num.length-1;
        while(l<r) {
            int mid = (l+r)/2;
            if (num[mid] > num[r]) { l = mid+1; }
            else if(num[mid] < num[r]) { r = mid;}
            else  r--;
        }
        return num[l];
    }
}*/

/**
 * Using both right & left
 */
 
public class Solution {
    public int findMin(int[] num) {
        int l = 0, r = num.length-1;
        while(l<r) {
            if (num[l] < num[r])   return num[l];
            int mid = (l+r)/2;
            if (num[mid] > num[r]) { l = mid+1; }
            //else if(num[mid] < num[r]) { r = mid;}    // redundant
            else if(num[mid] < num[l]) { l++; r = mid; }
            //else if(num[mid] > num[l]) { l = mid+1; } // redundant
            else  { r--; l++; }
        }
        return num[l];
    }
}
