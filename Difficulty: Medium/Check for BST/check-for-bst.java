class Solution {
    boolean ans = true;
    int[] solve(Node root) {
        if(root == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        if(root.data <= left[1]) ans = false;
        if(root.data >= right[0]) ans = false;
        
        return new int[]{Math.min(left[0], root.data), Math.max(right[1], root.data)};
    }
    public boolean isBST(Node root) {
        // code here
        solve(root);
        return ans;
    }
}