/**
 * For two sum, we can use bi-directional two pointers to calculate a given number
 * and so on....
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list;
        
        for(int i=0; i<num.length;) {
            int l = i+1, r = num.length-1;
            int target = 0 - num[i];
            
            while(l < r) {
                if (num[l] + num[r] == target) {
                    //list = new ArrayList<>(Arrays.asList(num[i]));
                    //list.add(num[l]);list.add(num[r]);
                    list = new ArrayList<>(Arrays.asList(num[i], num[l], num[r]));
                    lists.add(list);
                    r--; l++;
                    while(l < r && num[l] == num[l-1]) l++;         // for unique
                    while(l < r && num[r] == num[r+1]) r--;
                } else if (num[l] + num[r] > target) { r--; 
                } else { l++; }
            }
            
            i++;
            while(i<num.length && num[i] ==  num[i-1])  i++;
        }
        
        return lists;
    }
}
