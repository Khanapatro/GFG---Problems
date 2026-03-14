/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    static class Range {
        int left, right;
        Range(int l, int r) { left = l; right = r; }
    }
    public ArrayList<Integer> topView(Node root) {
        if (root == null) return new ArrayList<>();

        Range range = new Range(0, 0);
        find(root, 0, range);
        int n = range.right - range.left + 1;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));
        ArrayList<Integer> level = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        Tview(root, -range.left, ans, level, 0);
        return ans;
    }
    void Tview(Node root, int pos, ArrayList<Integer> ans, ArrayList<Integer> level, int depth) {
        if (root == null) return;
        if (level.get(pos) > depth) {
            ans.set(pos, root.data);
            level.set(pos, depth);
        }
        Tview(root.left, pos - 1, ans, level, depth + 1);
        Tview(root.right, pos + 1, ans, level, depth + 1);
    }
    void find(Node root, int pos, Range range) {
        if (root == null) return;
        range.left = Math.min(range.left, pos);
        range.right = Math.max(range.right, pos);
        find(root.left, pos - 1, range);
        find(root.right, pos + 1, range);
    }
}
