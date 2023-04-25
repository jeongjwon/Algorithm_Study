class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Leetcode_687_Longest_Univalue_Path {
    static int path = 0;
    public static int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        int leftPath = 0, rightPath = 0;

        //root => parent , root.right / root.left => children
        if(root.left != null && root.val == root.left.val){
            leftPath += left+1;
        }
        if(root.right != null && root.val == root.right.val){
            rightPath += right+1;
        }
        path = Math.max(path, leftPath + rightPath);

        System.out.println("현재 : "+root.val + " leftPath : "+leftPath + "  rightPath : "+rightPath + "  path : " +path);
        return Math.max(leftPath, rightPath);
    }
    public static int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        
        dfs(root);

        return path;
       

    }
    public static void main(String[] args){
        TreeNode root = new TreeNode(5);

        TreeNode left =  new TreeNode(5);
        TreeNode right = new TreeNode(5);

        TreeNode left_left = new TreeNode(4);
        TreeNode left_right = new TreeNode(4);
        
        TreeNode right_left = new TreeNode(5);
        TreeNode right_right = new TreeNode(5);

        left.left = left_left;
        left.right = left_right;
        right.right = right_right;
        right.left = right_left;

        root.left = left;
        root.right = right;

        System.out.println(longestUnivaluePath(root));

    }
}
