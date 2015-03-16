/**
 * 1. Since the input is already sorted, we can use binary Search, so that no extra space.
 * 
 * 2. But in fact we have more efficenet solution for this, since it has already been sorted,
 * two pointers i ->  ; j <-
 * 
 * This is binary search first
 **/
 
/*public class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for (int i=0; i<numbers.length; i++) {
            int remain = target - numbers[i];
            
            if (remain < numbers[i]) break;
            
            int index = binarySearch(numbers, remain, i+1);
            
            if (index != -1) {  // find the remain
                res[0] = i+1;
                res[1] = index+1;
                break;
            }
        }
        
        return res;         // XXX missing this first time
    }
    
    public int binarySearch(int[] numbers, int target, int start) {
        int left = start, right = numbers.length-1;
        if (target < numbers[left] || target > numbers[right])  return -1;      // not in the range
        
        while(left <= right) {
            int mid = (left + right)/2;
            
            if (numbers[left] == target)    return left;
            if (numbers[right] == target)   return right;
            if (numbers[mid] == target)     return mid;
            
            if (numbers[mid] > target)      right = mid-1;
            else left = mid+1;
        }
        
        return -1;
    }
}*/


public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length-1;
        
        while (left < right) {
            
            int sum = numbers[left] + numbers[right];
            if (sum == target) { return new int[] {left+1, right+1};    // XXXXXXXXXXXX
            }else if (sum > target) { right--; 
            }else { left++; }
        }
        
        throw new IllegalArgumentException("Not Found Valid Pairs!");   //  XXXXXXXXXXXX    
        
        
    }
}
