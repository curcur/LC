/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
 
/**
 * - If we use y = ax+b
 *   then we need O(n^3): O(n^2) to decide a & b
 *                      and another loop to decide the maximal a & b
 * 
 * - x0, y0, (y1-y0)/(x1-x0) = (y2-y0)/(x2-x0)  
 * - HashMap can accurately hold Double in Java
 * - A lot of details to consider
 *      - the same axis
 *      - different points with the same coordinates
 *      - do not need to consider points have already considered
 */

public class Solution {
    public int maxPoints(Point[] points) {
	int length = points.length;
	if (length == 0)
	    return 0;
	
	int maxpoints = 0;
	Map<Double, Integer> map = new HashMap<>();
	
	for (int i = 0; i < length; i++) {
	    map.clear();
	    // xaxis records points with the same x coordinate
	    int xaxis = 0, yaxis = 0, max = 0, samepoints = 1;

	    // XXXX j=i+1
	    for (int j = i + 1; j < length; j++) {
		// XXXX same points can be counted as any rate
		if (points[j].x == points[i].x && points[j].y == points[i].y)
		    samepoints++;
		else if (points[j].x == points[i].x)
		    xaxis++;
		// XXXX Java take +0.0 & -0.0 differently, 
		// XXXX hence we consider y differently
		else if (points[j].y == points[i].y)
		    yaxis++;
		else {
		    double rate = ((double) (points[j].y - points[i].y))
			/ ((double) (points[j].x - points[i].x));
		    if (!map.containsKey(rate))
			map.put(rate, 0);
		    int otherpoints = map.get(rate) + 1;
		    max = Math.max(max, otherpoints);
		    map.put(rate, otherpoints);
		}
	    }
	    max = Math.max(xaxis, max);
	    max = Math.max(yaxis, max);
	    maxpoints = Math.max(maxpoints, max+samepoints);
	}
	return maxpoints;
    }
}
