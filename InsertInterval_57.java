/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
/**
 * 1.A & B Overlap:
 * A.start <= B.end && B.start <= A.end
 * 
 * I also think about binary search, however, binary search O(log(n)) needs this to be an random accessible structure. when overlapping, removing & merging will cause the structure O(n) time
 * So, I just treat this as a list & start fromthe beginning;
 */ 
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0 || newInterval.start > intervals.get(intervals.size()-1).end)  {  
            intervals.add(newInterval);  return intervals; 
        }
        
        int index = 0;
        while(index<intervals.size()) {
            Interval i = intervals.get(index);
            // overlap
            if (i.start <= newInterval.end && newInterval.start <= i.end)   {
                i.start = Math.min(i.start, newInterval.start);
                i.end = Math.max(i.end, newInterval.end);
                break;  // find overlap & update it
            }
            // XXXX  before
            if (newInterval.end < i.start) {                //XXXXXXXXXX the most common case
                intervals.add(index, newInterval);          // {[1, 2], [5, 6]}  [3, 4]
                return intervals;
            }
            index++;
        }
        
        // merge till the end
        int indexj = index+1;
        while(indexj<intervals.size()) {
            Interval i = intervals.get(index), j = intervals.get(indexj);
            if (i.start <= j.end && j.start <= i.end) {
                i.start = Math.min(i.start, j.start);
                i.end = Math.max(i.end, j.end);
                intervals.remove(j);
            } else break;
        }
        return intervals;
    }

}
