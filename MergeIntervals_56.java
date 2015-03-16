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
 * My Thoughts:
 * We have two problems here
 * 1. How to identify no overlapping intervals
 * A.end <= B.start || B.end <= A.start   =>
 * overlapping : A.end > B.start && B.end > A.start
 * 2. How to merge all of them
 * Sorting the intervals 
 *  1) sorting based on end: endI
 *  2) sorting based on start: startI
 * 
 * for first interval in endI
 * find the intervals in startI starting before endI.end
 * this is too complicated since we need to matain two lists!
 * 
 * Further Thoughts after refer solution: just sorting the start
 * Starting from the first interval in startI, merge it with remaining intervals in startI one by one
 * if the remaining intervals' start is before first interval's end.
 * update the first interval's start and end respectively. remove the merged one
 * 
 * Try to write inline Comparator
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;}});
        int index = 0;
        while(index < intervals.size()) {
            Interval i1 = intervals.get(index);
            int j = index+1;
            if(j<intervals.size() && intervals.get(j).start <= i1.end) {
                i1.end = Math.max(i1.end, intervals.get(j).end);
                intervals.remove(j);
            }else index++;
        }
        return intervals;
    }
}
