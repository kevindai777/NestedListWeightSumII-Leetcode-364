//Java Solution

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = getMaxDepth(nestedList);
        return dfs(nestedList, maxDepth);
    }
    
    public int getMaxDepth(List<NestedInteger> list) {
        int depth = 0;
        
        for (NestedInteger element : list) {
            if (!element.isInteger()) {
                depth = Math.max(depth, getMaxDepth(element.getList()));
            }
        }
        
        return depth + 1;
    }
    
    public int dfs(List<NestedInteger> list, int depth) {
        int sum = 0;
        
        for (NestedInteger element : list) {
            if (element.isInteger()) {
                sum += element.getInteger() * depth;
            } else {
                sum += dfs(element.getList(), depth - 1);
            }
        }
        
        return sum;
    }
}