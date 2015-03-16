/**
 * XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
 * My First thought is adding () to previous F[i-1], but this is not right
 * It will have many duplicates if symmetric.
 * -- F[i] = (F[i-1]) + F[i-1]() + ()F[i-1]
 * -- ()()() only has one, add to left or right is the same
 *
 * 1. Recursion --  This is not right!
 *
public class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new LinkedList<>();
        if (n == 1) return new LinkedList<>(Arrays.asList("()"));
        
        List<String> list = generateParenthesis(n-1); 
        int length = list.size();
        for(int i=0; i<length; i++) {
            String s = list.remove(0);
            list.add("(" + s + ")");
            list.add(s + "()");
            if (i!=length-1) list.add("()" + s);
        }
        return list;
    }
}*/

/**
 * 1. Recursive
 * F[i,j] -- i left parenthesis, j right parenthesis
 * F[i,0] = 1 if j=0 
 * F[i,j] = 0 if j>i
 */
/*public class Solution {
    public List<String> generateParenthesis(int n) {
        return generateParenthesis(n, n);
    }
    
    // i left parenthesis, j right parenthesis
    private List<String> generateParenthesis(int i, int j) {
        if (j > i || i<0 || j<0)  return null;
        if (j == 0 && i == 0)   return new ArrayList<String>(Arrays.asList(""));
        
        List<String> list = new ArrayList<>();
        List<String> l1 = generateParenthesis(i-1, j);
        if (l1 != null) 
            for(String s : l1) list.add(s+"(");
        
        List<String> l2 = generateParenthesis(i, j-1);
        if (l2 != null)
            for(String s : l2) list.add(s+")");
        
        return list;
    }
}*/

/**
 * ***********
 * The previous method has calculated some combinations many times.
 * 2. Iteratively:
 */
/*public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>[][] lists = new List[n+1][n+1];
        lists[0][0] = new ArrayList<>(Arrays.asList(""));
        
        for(int i=1; i<=n; i++)
            for (int j=0; j<=i; j++) {
                lists[i][j] = new ArrayList<>();
                if (j<=i-1) for (String s: lists[i-1][j]) lists[i][j].add(s+"(");
                if (j >= 1) for (String s: lists[i][j-1]) lists[i][j].add(s+")");
            }
        
        return lists[n][n];
    }
}*/

/**
 * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 * $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
 * 3. Think about using DFS w/o storing any intermediate results
 * 
 * This is a very typical DFS finding all paths using recursion
 */
public class Solution {
    List<String> lists = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateParenthesis(0, 0, new StringBuilder(""), n);
        return lists;
    }
    
    private void generateParenthesis(int left, int right, StringBuilder str, int n) {
        if (left == n && left == right) { lists.add(str.toString());  return; }
        
        if (left < n)   {
            generateParenthesis(left+1, right, str.append("("), n);
            str.deleteCharAt(str.length()-1);
        }
        if (right < left) {
            generateParenthesis(left, right+1, str.append(")"), n);
            str.deleteCharAt(str.length()-1);
        }
    }
}
